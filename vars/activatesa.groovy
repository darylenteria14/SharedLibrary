#!/usr/bin/env groovy

def call(Map config = [:]) {
    echo "Configuire GCP Service Account"
    def gcpconfig = new com.ApigeePlatform.CICD()
    gcpconfig.checkOutFrom("${config.repoName}")
    gcpconfig.gcpAuth("${config.serviceAccount}","${config.projectID}")
    gcpconfig.setEnvVars("${config.projectID}")
}