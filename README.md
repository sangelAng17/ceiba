# Autor : Angel Santiago Hernandez 
# PRUEBA TECNICA CEIBA


# Fecha: 20/06/2025
# Empresa: BTG Pactual
## Parte 1 – Fondos (80%)
## Necesidad de negocio:

BTG Pactual desea crear una plataforma que permita a los clientes gestionar sus fondos de
inversión sin necesidad de contactar a un asesor. Las funcionalidades requeridas son:
Funcionalidades del sistema:
1. Suscribirse a un nuevo fondo (apertura).
2. Cancelar la suscripción a un fondo actual.
3. Ver historial de transacciones (aperturas y cancelaciones).
4. Enviar notificación por email o SMS según preferencia del usuario al suscribirse a un

## fondo.
## Reglas de negocio:
Monto inicial del cliente: COP $500.000.
Cada transacción debe tener un identificador único.
Cada fondo tiene un monto mínimo de vinculación.
Al cancelar una suscripción, el valor de vinculación se retorna al cliente.
Si no hay saldo suficiente, mostrar:
“No tiene saldo disponible para vincularse al fondo <Nombre del fondo>”
Información de los fondos:
ID Nombre Monto mínimo Categoría
1 FPV_BTG_PACTUAL_RECAUDADORA COP $75.000 FPV
2 FPV_BTG_PACTUAL_ECOPETROL COP $125.000 FPV
3 DEUDAPRIVADA COP $50.000 FIC
4 FDO-ACCIONES COP $250.000 FIC
5 FPV_BTG_PACTUAL_DINAMICA COP $100.000 FPV


## Actividades solicitadas:
1. Tecnologías sugeridas: Python con FastAPI, .NET Core, Java Springboot o Express -
Node.js
2. Diseñar un modelo de datos NoSQL que soporte las operaciones.
3. Construir una API REST que implemente las funcionalidades descritas.
4. Incluir:
 - Manejo de excepciones.
 - Código limpio (Clean Code).
 - Pruebas unitarias.
 - Buenas prácticas de seguridad y mantenibilidad.
5. Definir los procesos de autenticación, autorización, perfilamiento por roles y
encriptación.
6. Despliegue: El backend debe poder desplegarse mediante AWS CloudFormation, con
documentación incluida.
5. Deseable que toda la infraestructura y los recursos utilizados estén desplegados en AWS.
Internal Use Only
Parte 2 – SQL (20%)
Base de datos: BTG
Escriba las consultas SQL correspondientes, para ello, tenga en cuenta la base de datos
llamada “BTG” la cual tiene las siguientes tablas (tenga en cuenta que se puede presentar el
caso de que no todas las sucursales ofrecen los mismos productos).
Tablas disponibles:
Internal Use Only
Internal Use Only
Consulta solicitada:
Obtener los nombres de los clientes que tienen inscrito algún producto disponible solo en
las sucursales que visitan.

## Pruebas funcionales 

<img width="1317" height="495" alt="image" src="https://github.com/user-attachments/assets/8ea1953e-2f03-44ad-aba1-4503de7873b8" />


### Consumo Post 
<img width="1085" height="77" alt="image" src="https://github.com/user-attachments/assets/fb5b310c-c576-4a01-b5e0-6b509c9dbf66" />


<img width="1213" height="585" alt="image" src="https://github.com/user-attachments/assets/16aa5b9f-fc9d-4213-b63f-ed550de0aea4" />

<img width="993" height="336" alt="image" src="https://github.com/user-attachments/assets/83ebd760-c81e-48e7-989b-815e8599be4a" />

### Consumo Delete 
<img width="1071" height="33" alt="image" src="https://github.com/user-attachments/assets/0ef5c344-16fd-4193-91b7-5bc7b89c331c" />

<img width="1083" height="590" alt="image" src="https://github.com/user-attachments/assets/771e76d0-0f15-477e-9ac0-ced9727124ea" />

<img width="1083" height="591" alt="image" src="https://github.com/user-attachments/assets/0b9496d5-8802-47c4-bc77-23f5e1746d78" />

### Consumo Get

<img width="1083" height="587" alt="image" src="https://github.com/user-attachments/assets/d289e63a-a582-4fe2-b813-721c670f3784" />

<img width="1068" height="232" alt="image" src="https://github.com/user-attachments/assets/966ff6f7-d9c7-4284-ab71-38b9a85aa632" />

### MongoDB
<img width="370" height="348" alt="image" src="https://github.com/user-attachments/assets/9bef30e1-879a-4cc1-808b-c2b020636427" />

![Uploading image.png…]()

