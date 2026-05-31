def call(String backendImage, String frontendImage) {

    echo "Pushing Docker images"

    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-credentials',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {

        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"

        sh "docker image tag djangocicd-backend:latest ${dockerHubUser}/djangocicd-backend:latest"
        sh "docker push ${dockerHubUser}/djangocicd-backend:latest"

        sh "docker image tag djangocicd-frontend:latest ${dockerHubUser}/djangocicd-frontend:latest"
        sh "docker push ${dockerHubUser}/djangocicd-frontend:latest"
    }
}
