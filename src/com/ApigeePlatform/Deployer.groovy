class Deployer implements Serializable {
   def steps
   Deployer(steps) {
      this.steps = steps
   }

    def callMe() {
        // Always call the steps object
        steps.echo("Test")
        steps.echo("${steps.env.BRANCH_NAME}")
        steps.sh("ls -al")

        // Your command could look something like this:
        // def process = steps.sh(script: "ls -l", returnStdout: true).execute(steps.env, null)
        ...
    }
}
