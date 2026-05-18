def call() {
  
sh "docker compose down"

sh "docker compose up -d"

 echo "Application deployed successfully"
}
