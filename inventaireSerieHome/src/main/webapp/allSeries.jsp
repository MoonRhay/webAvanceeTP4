<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<script src="<c:url value = '/webjars/vue/2.5.16/vue.js'/>"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>	
	<title>Inventaire de series</title>
</head>

<body>
<h1>Hello</h1>
<div id="app">
	<button v-on:click="getSeries()">Liste Serie</button>
	<p>{{ info }}</p>
	<p>info de la réponse : <br/> {{ infoResp }}</p>
  
	<table>
	        <thead>
	            <tr>
	                <th>Numéro liste</th>
	                <th>Nom série</th>
	                <th>Nombres saison</th>
	                <th>Acteur principal</th>
	                <th>Vo ou non</th>
	            </tr>
	        </thead>
            <tr v-for="serie in series">
                <td>{{serie.numList}}</td>
                <td>{{serie.nom}}</td>
                <td>{{serie.numero}}</td>
                <td>{{serie.acteurPrincipalSerie}}</td>
                <td>{{serie.voOuNon}}</td>
           </tr>
		</table>
</div>
  
  <script>   
  var app = new Vue({
      el: '#app',
      data: {
          series: null
        },
      methods: {
        getSeries: function () { 
              this.$http.get('http://localhost:8081/series').then(response => {
            	  var test = JSON.stringify(response);
            	  
            	  this.series = response.body;
            	    }, response => {
    // traiter en cas d'erreur
  });

    }
    }
  })
  </script>

</body>
</html>