# Utilisez l'image de base Node.js avec une version spécifique
FROM node:18.10.0

# Définissez le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copiez les fichiers package.json et package-lock.json
COPY package*.json ./

# Installez les dépendances
RUN yarn install

# Copiez le reste des fichiers de votre projet
COPY . .

# Exposez le port sur lequel l'application écoute
EXPOSE 3000

# Démarrez l'application lorsque le conteneur démarre
CMD ["yarn", "run", "dev"]
