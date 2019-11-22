<%--
  Created by IntelliJ IDEA.
  User: sebas
  Date: 11/21/2019
  Time: 2:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/css/style.css"%></style>
    <title>Graph Web</title>
</head>
<body>

<div id="sigma-container"></div>



<div id="Node-Selected" class="Node-Individual">
    <label id="Title-Nodo"> Nodo seleccionado</label>
    <label id="Node-Field"> Name</label>
    <button id="Button-Update" > Actualizar</button>
    <button id="Button-Info"> Información</button>
    <button id="Button-Delete"> Eliminar</button>
    <button id="Button-Node"> Nodo</button>
</div>



<div class="Graph-Options">
    <label id="Graph-Name">Nombre del grafo:</label>
    <label id="Graph-ID">ID del grafo:</label>
    <button id="Add-Nodes" onclick="">Agregar nodo</button>
    <button id="Manage-Edges">Administrar aristas</button>
</div>


<aside class="List_Graph">
    <div id="Scroll-Graphs"></div>

    <b>Lista de Grafos</b>
</aside>


<aside class="Options_list_Graph">
    <button id="Update-List_Graph">Actualizar</button>
    <button id="Import-CSV">Importar CSV</button>

</aside>


<aside class="Shortest-Path">
    <label id="Shortest-Path-title">Ruta más corta</label>

    <button id="Shortest-Path-Button">Buscar</button>


    <button id="Name-Node-Source">Source</button>

    <button id="Name-Node-Target">Target</button>

    <div id="List-Nodes-Shortest-Path"></div>

    <b id="Weight">Peso: </b>
    <label id="Weight-label"></label>

</aside>
</body>
</html>