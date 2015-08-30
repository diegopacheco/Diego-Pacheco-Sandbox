// 1. Create a free style project
// 2. Add a build step for DSL job
// 3. Copy this file to the workspace: C:\Users\diego\.jenkins\jobs\dsl-jenkins-fun\workspace
// 4. Add script from FS: **/*.groovy
// 5. Have fun
// Tutorial: https://github.com/jenkinsci/job-dsl-plugin/wiki/Tutorial---Using-the-Jenkins-Job-DSL
//
job('DSL-Tutorial-1-Test') {
    scm {    
        git('https://github.com/quidryan/aws-sdk-test.git')
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}