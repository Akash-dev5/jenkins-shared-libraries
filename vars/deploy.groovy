/*def call() {
  
sh "docker compose down"

sh "docker compose up -d"

 echo "Application deployed successfully"
} */

def call(String backendTag, String frontendTag) {
    echo "Deploying application version Backend:${backendTag} Frontend:${frontendTag}"
    
    // stop old containers
    sh "docker compose down"
    
    // pull latest versioned images from dockerhub
    sh "docker pull acethedata/djangocicd-backend:${backendTag}"
    sh "docker pull acethedata/djangocicd-frontend:${frontendTag}"
    
    // start new containers
    sh "docker compose up -d"
    
    echo "Application deployed successfully!"
    echo "Backend version: ${backendTag}"
    echo "Frontend version: ${frontendTag}"
}
