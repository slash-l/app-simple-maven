pipeline {
    agent any
    stages {
        stage ('Clone') {
            steps {
                git branch: 'develop', url: "git@github.com:slash-l/app-simple-maven.git"
            }
        }

        stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "JFrogChina-Server",
                    url: "https://demo.jfrogchina.com/artifactory/",
                    credentialsId: "JFrogChina-accessToken"
                )

                rtMavenDeployer (
                    id: 'deployer-unique-id',
                    serverId: "JFrogChina-Server",
                    releaseRepo: "slash-maven-dev-local",
                    snapshotRepo: "slash-maven-dev-local"
                )

                rtMavenResolver (
                    id: 'resolver-unique-id',
                    serverId: "JFrogChina-Server",
                    releaseRepo: "slash-maven-virtual",
                    snapshotRepo: "slash-maven-virtual"
                )
            }
        }

        stage ('Exec Maven') {
            steps {
                rtMavenRun (
                    tool: 'maven', // Tool name from Jenkins configuration
                    pom: 'pom.xml',
                    goals: 'clean install',
                    resolverId: 'resolver-unique-id'
                )

                rtPublishBuildInfo (
                    serverId: "JFrogChina-Server"
                )

                xrayScan (
                    serverId: "JFrogChina-Server",
                    failBuild: false
                )

                rtMavenRun (
                    tool: 'maven', // Tool name from Jenkins configuration
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: "deployer-unique-id",
                    resolverId: 'resolver-unique-id'
                )
            }
        }


    }
}