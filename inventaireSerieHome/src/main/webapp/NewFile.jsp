<!DOCTYPE html>
<html>
<head>
  <title>Welcome to Vue</title>
  <script src="https://unpkg.com/vue"></script>
</head>
<body>
  <div id="app">
    <h1>{{ greeting }}</h1>
	<button v-on:click="getSeries">Liste Serie</button>
  </div>

<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
  <script>
    var app = new Vue({
      el: '#app',
      data: {
        greeting: 'Bienvenue dans votre bibliothèque de série!',
        docsURL: 'http://vuejs.org/guide/',
        discordURL: 'https://chat.vuejs.org',
        forumURL: 'http://forum.vuejs.org/'
      },
      methods: {
        getSeries: function () { 
              this.$http.get('http://localhost:8081/series').then(response => {
            	  var test = JSON.stringify(response);
            	  alert(test);         	  
/*     var test = JSON.parse(response);
    alert(test.titre); */
  }, response => {
    // traiter en cas d'erreur
  });

    }
    }
  })
  </script>
</body>
</html>