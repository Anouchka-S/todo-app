todo-app
=============

LE TALLEC Florian / SEEGOBIN Anouchka

Bienvenue sur l'application `MyTodo` qui permet de gérer ses taches.
L'application permet, de récupperer, d'ajouter, de modifier et de supprimer des tâches

Présentation de la stack
--------------------
Ce projet web est commposé d'un back et d'un front :

- **Front-end :** Nous avons utilisé [Vite.js](https://vitejs.dev/), un outil de développement rapide basé sur
  JavaScript, pour optimiser les performances de notre application. Nous avons également utilisé TypeScript pour
  bénéficier de la vérification statique des types et faciliter la maintenabilité du code. Enfin, nous avons construit
  l'interface utilisateur en utilisant React.


- **Back-end :** Pour la partie back-end de notre application, nous avons choisi Java et Maven pour la gestion des
  dépendances. Nous avons utilisé une framework proche de Spring appelée Plume développé par Coreoz pour faciliter le
  développement de
  notre API. Nous avons opté pour une base de données H2, une base de données relationnelle en mémoire, pour des raisons
  de simplicité et de facilité de déploiement. Enfin, nous avons utilisé Querydsl, un framework de requête SQL.

Lancer le projet
--------------------

### Lancer le back

Pour lancer le back vous pouvez utiliser le jdk **openjdk-18**, ensuite une fois que les dépendances maven son intallés
il
il faut se rendre dans le fichier `WebApplication.java` est le `run`. Ce fichier se trouve dans le dossier :
`src/main/com.todo`.

Une fois le back lancé, vous pouver lancer le front.

### Lancer le front

- Le projet tourne avec la version de node : 18.10.0
- pour installer yarn vous pouvez executer la commande ci-dessous
- Ouvrez le terminal à la racine du projet
- entrez la commande `cd front`
- entrez la commande `yarn` pour installer les dépendances
- entrez la commande `yarn run dev`
- cliquez sur le lien

```
npm install --global yarn
```

Avancement du projet
--------------------

### 1. Create a web application

- Langages choisis Java,Typescript
- Base de données H2

Le CRUD fonctionne

### 2. Apply CI/CD pipeline

- Nous avons utilisé des gitlab CI/CD, pour verifier le back et le front

### 3. Configure and provision a virtual environment and run your application using the IaC approach

- Nous n'avons pas fait cette partie

### 4. Build Docker image of your application

- Pour docker nous avons fait le choix d'avoir deux images docker séparées, une pour le back et une pour le front.
- Pour le back l'image build mais au moment de la start on rencontre un problème avec la base H2.
- Pour le front pas de problèmes tout fonctionne, mais difficile à tester car le fonctionnement de l'app dépend du back.

## How to get bonuses?

Every initiative will be counted, just don't forget to describe it in your `README.md`.

List of bonus tasks proposed:

1. Use different tools and platforms instead of what has been passed in the labs, for example, GitLab CI/CD, Netlify,
   etc. This will give you a bigger overview of technologies.
2. Use different languages (Java, Ruby, Python, etc.) to develop the application of part 1.
3. If you use the NodeJS application provided in
   the [modules/04.ct-ci-cd/assets/userapi](modules/04.ct-ci-cd/assets/userapi) folder, bring it with additional
   features:

- more different API methods
- more different unit/functional/integration tests
- using another database (like MongoDB, MySQL, ...)
- integrate a documenting package to your source code, for
  example, [Swagger UI](https://www.npmjs.com/package/express-swagger-generator)

4. Any Kubernetes tasks from [this list](https://kubernetes.io/docs/tasks/).
5. [Securing microservice communication](https://istio.io/latest/docs/tasks/security/) or any other task with Istio.
6. Etc.

- 1 - nous avons utilisé des pipelines Gitlab
- 2 - nous avons utilisé différents langages (typescript, java)
- 3 - nous avons mis en place un swagger que vous pouvez
  retrouver [ici](http://localhost:8080/webjars/swagger-ui/4.1.2/index.html?url=/api/swagger) lorsque le projet est
  lancé
  indentifiant : ece / mdp: devops
  (lien : `http://localhost:8080/webjars/swagger-ui/4.1.2/index.html?url=/api/swagger`)

Corrrection
--------------------
Les commits sous le pseudo erwanLv viennent de Florian LE TALLEC (nom associé à la clé ssh)

Si vous rencontrez des problèmes pour lancer le projet n'hésitez pas à envoyer un mail à nos adresses mails :
florian.letallec@edu.ece.fr
anouchka.seegobin@edu.ece.fr

Vous pouvez retrouver des screens du site dans le dossier screenshot à la racine du projet
