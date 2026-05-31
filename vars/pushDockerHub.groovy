def call(String backendImage, String frontendImage) {

    echo "Pushing Docker images"

    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-credentials',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {

        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"

        sh "docker image tag djandocicd-backend:latest ${dockerHubUser}/djandocicd-backend:latest"
        sh "docker push ${dockerHubUser}/djandocicd-backend:latest"

        sh "docker image tag djandocicd-frontend:latest ${dockerHubUser}/djandocicd-frontend:latest"
        sh "docker push ${dockerHubUser}/djandocicd-frontend:latest"
    }
}
