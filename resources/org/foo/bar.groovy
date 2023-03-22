package org.foo

def checkOutFrom(repo) {
  // git url: "git@github.com:jenkinsci/${repo}"
  sh 'ls -l'
}

return this
