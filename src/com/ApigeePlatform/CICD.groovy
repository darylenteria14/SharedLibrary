// Class Definiton
package com.ApigeePlatform

// Funtion for git clone
def checkOutFrom(repo) {
  env.GIT_REPO = "${repo}"
  sh '''
  echo "git@github.com:jenkinsci/${GIT_REPO}"
  '''
}
// Funtion to set Env Variables
def setEnvVars(projectid) {
    env.PROJECT_ID = "${projectid}"
    sh '''
    echo $PROJECT_ID
    #gcloud services enable \
    #apigee.googleapis.com \
    #apigeeconnect.googleapis.com \
    #cloudresourcemanager.googleapis.com \
    #pubsub.googleapis.com  --project ${PROJECT_ID}
    '''
}

def gcpAuth(serviceaccount,projectid) {
  env.gcpsa = "${serviceaccount}"
  env.PROJECT_ID = "${projectid}"
  withCredentials([file(credentialsId: 'apigee-nonprod', variable: 'apigeeSA')]) {
  sh '''
  echo "print ${gcpsa}"
  gcloud version | head -1
  gcloud auth activate-service-account \
        --key-file="${apigeeSA}" --project=${PROJECT_ID}
  '''
  }
}

return this
