/*def call(String backendImage, String frontendImage) {

    echo "Pushing Docker images"

    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-credentials',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {

        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker push ${dockerHubUser}/djangocicd-backend:latest"
        sh "docker push ${dockerHubUser}/djangocicd-frontend:latest"
    }
 } */

def call(String backendImage, String frontendImage, String backendTag, String frontendTag) {
    echo "Pushing Docker images"
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-credentials',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker push ${dockerHubUser}/${backendImage}:${backendTag}"
        sh "docker push ${dockerHubUser}/${frontendImage}:${frontendTag}"
    }
}
