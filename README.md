# Challenge Wenance
***

<h2>Java version:</h2> 1.8

<h2>Ejecución local</h2>
<p>Git clone https://github.com/NevadoSantiago/WChallenge.git</p>
<p>mvn install</p>
<p>mvnw spring-boot:run</p>
<p>Dominio por defecto: localhost:8080</p>

<h2>Descripción</h2>
<p>Al ejecutarse se llama a una funcion que se repite cada cierto tiempo (10 segundos en este caso). La misma obtiene el precio actual del BTC.</p>
<p>Se exponen 2 API's para consulta de datos:</p>
<li>DOMINIO/api/BTC/getPrice/{time} -- TIME: dd-MM-yyyyTH:mm:ss</li>
<li>DOMINIO/api/BTC/getAverage/{from}/{to} -- FROM: dd-MM-yyyyTH:mm:ss -- TO: dd-MM-yyyyTH:mm:ss</li>

<p>El primer endpoint devuelve el valor del BTC en ese instante </p>
<p>El segundo endpoint devuelve el valor promedio del BTC entre las fechas indicadas y un porcentaje de diferencia entre el promedio y el precio mayor historico (En memoria) </p>

<h2>Respuesta del servidor</h2>
{
	response: Object,
	status: Integer,
	message: String 
}
