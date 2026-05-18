def call() {

    echo "Building Docker images"

    sh "docker compose build"

    echo "Docker build completed"
}
