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
