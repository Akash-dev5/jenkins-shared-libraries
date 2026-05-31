/*def call() {

    echo "Building Docker images"

    sh "docker compose build"

    echo "Docker build completed"
} */

def call(String backendTag, String frontendTag) {
    echo "Building Docker images"
    sh "docker compose build"
    sh "docker image tag djangocicd-backend:latest acethedata/djangocicd-backend:${backendTag}"
    sh "docker image tag djangocicd-frontend:latest acethedata/djangocicd-frontend:${frontendTag}"
    echo "Docker build completed"
}
