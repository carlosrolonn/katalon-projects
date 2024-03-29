import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Mobile.startExistingApplication('com.artico.delivery.pedidos')

not_run: Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Seleccion de primer direccion'
not_run: Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.view.ViewGroup - Selector de direccion'), 
    0)

'extrae titulo de la direccion en la home'
String DireccionHome = Mobile.getText(findTestObject('Object Repository/Login email/V4/android.widget.TextView - Direccion Home'), 0).replace("Enviar a ", "").replaceAll("\\s", "")

'imprime titulo de la direccion en la home'
println(DireccionHome)

'Banner comida'
Mobile.tap(findTestObject('Object Repository/Finalizar POS/android.view.ViewGroup - Banner comida'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Filtro pago online'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Pago Online'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Entrar en campo de busqueda'
Mobile.tap(findTestObject('Object Repository/Finalizar POS/android.widget.EditText - Buscar en todas las categoras'), 
    0)

'busqueda de comercio'
Mobile.setText(findTestObject('Object Repository/Finalizar POS/android.widget.EditText - Buscar en todas las categoras'), 
    'masapan' + '\\n', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'entra en el comercio'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Titulo Masapan'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Entra en el primer producto'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Primer Producto'), 
    0)

'Suma cantidad'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - SumaProducto'), 0)

'Agrega al carrito'
Mobile.tap(findTestObject('Finalizar con Cupon/android.widget.TextView - Agregar a carrito'), 0)

'Va al carrito'
Mobile.tap(findTestObject('Finalizar con Cupon/android.widget.TextView - Carrito (1)'), 0)

'extrae titulo de la direccion en el carrito'
String DireccionCarrito = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Direccion Carrito'), 0)

'imprime titulo de la direccion en el carrito'
println(DireccionCarrito)

'Pago y facturacion'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Pago y Facturacin'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'extrae titulo de la direccion en el finalize'
String DireccionFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Direccion Finalize'), 0)

'imprime titulo de la direccion en el finalize'
println(DireccionFinalize)

'obtiene el total sin descuento del finalize'
String extractFinalize = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total finalize sin cupon'), 
    0).replaceAll('[^0-9]', '')

'imprime monto finalize sin descuento (solo numero)'
println(extractFinalize)

'Abre selector de metodo pago'
Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Selector de pago'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Seleccion de tarjeta'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - BANCARD - CHECK - ENT. PRUEBA 1'), 
    0)

'Abre selector de cupones'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Cupones de descuentos'), 0)

'obtiene monto del cupon'
String extractCuponPorcentaje = Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView -   monto cupon percent'), 
    0).replaceAll('[^0-9]', '')

'imprime monto cupon (solo numero)'
println(extractCuponPorcentaje)

'Seleccionar primer cupon'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Seleccionar primer cupon'), 0)

'Verifica mensaje de exito'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - Cupn verificado exitosamente'), 0)

'Cierra mensaje de cupon'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.view.ViewGroup - Cierra mensaje de cupon'), 0)

'obtiene monto del descuento aplicado'
String extractCupon = Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - monto cupon aplicado 2'), 
    0).replaceAll('[^0-9]', '')

'imprime monto cupon del descuento aplicado (solo numero)'
println(extractCupon)

'calculo de cuanto debe ser el monto a descontar según el porcentaje'
int calculoPorcentaje = (extractFinalize.toInteger() * extractCuponPorcentaje.toInteger()) / 100

'imprime calculo de cuanto debe ser el monto a descontar según el porcentaje'
println(calculoPorcentaje)

'calculo de cuanto debe ser el total final'
int calculoMonto = (extractFinalize.toInteger() - extractCupon.toInteger())

'imprime calculo de cuanto debe ser el total final'
println(calculoMonto)

'obtiene el total con descuento del finalize'
String extractFinalizeDescontado = Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Total con descuento aplicado 2'), 
    0).replaceAll('[^0-9]', '')

'imprime monto finalize con descuento (solo numero)'
println(extractFinalizeDescontado)

'validacion de monto de cupon y monto descontado'
if (extractCupon == calculoPorcentaje.toString()) {
    KeywordUtil.markPassed(((((((('EL CALCULO DE PORCENTAJE A DESCONTAR:' + ' ') + calculoPorcentaje.toString()) + ' ') + 
        'Y EL PORCENTAJE DESCONTADO:') + ' ') + extractCupon) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE PORCENTAJE A DESCONTAR:' + ' ') + calculoPorcentaje.toString()) + 
        ' ') + 'Y EL PORCENTAJE DESCONTADO:') + ' ') + extractCupon) + ' ') + 'NO COINCIDEN')
}

'validacion de monto total final'
if (extractFinalizeDescontado == calculoMonto.toString()) {
	KeywordUtil.markPassed(((((((('EL CALCULO DE TOTAL A PAGAR:' + ' ') + calculoMonto.toString()) + ' ') +
		'Y EL TOTAL FINAL CON DESCUENTO:') + ' ') + extractFinalizeDescontado) + ' ') + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop(((((((('EL CALCULO DE TOTAL A PAGAR:' + ' ') + calculoMonto.toString()) +
		' ') + 'Y EL TOTAL FINAL CON DESCUENTO:') + ' ') + extractFinalizeDescontado) + ' ') + 'NO COINCIDEN')
}

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'Finalizar'
Mobile.tap(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Finalizar Orden'), 0)

'Verifica proceso de pago'
Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Ya casi estamos, procesando pago'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

'extrae titulo de la direccion en el estado del pedido'
String DireccionEstado = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Direccion Estado Pedido'), 0)

'imprime titulo de la direccion en el estado del pedido'
println(DireccionEstado)

'validacion de las direcciones'
if (DireccionHome == DireccionCarrito && DireccionHome == DireccionFinalize && DireccionHome == DireccionEstado) {
	KeywordUtil.markPassed('LA DIRECCION EN LA HOME:' + ' ' + DireccionHome + '\n' +
						'LA DIRECCION EN EL CARRITO:' + ' ' + DireccionCarrito + '\n' +
						'LA DIRECCION EN EL FINALIZE:' + ' ' + DireccionFinalize + '\n'  +
						'LA DIRECCION EN EL ESTADO DE PEDIDO:' + ' ' + DireccionEstado + ' '  + 'COINCIDEN')
} else {
	KeywordUtil.markFailedAndStop('UNA DE LAS SIGUIENTES DIRECCIONES NO COINCIDE:\n' +
						'DIRECCION EN LA HOME:' + ' ' + DireccionHome + '\n' +
						'DIRECCION EN EL CARRITO:' + ' ' + DireccionCarrito + '\n' +
						'DIRECCION EN EL FINALIZE:' + ' ' + DireccionFinalize + '\n'  +
						'DIRECCION EN EL ESTADO DE PEDIDO:' + ' ' + DireccionEstado)
}

'Verifica estado recibido'
Mobile.getText(findTestObject('Finalizar con Cupon/android.widget.TextView - Recibido Estado de Pedido'), 0)

'Verifica descripcion de pago y cupon'
Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Pago Online - Cupn Descuento'), 
    0)

Mobile.scrollToText('CONTANOS', FailureHandling.STOP_ON_FAILURE)

'Verifica banner de calificacion'
Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - CONTANOS TU EXPERIENCIA'), 
    0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total en estado de pedido'
String extractEstado = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total estado de pedido'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total estado (solo numero)'
println(extractEstado)

'validacion de monto en finalize y estado de pedido (exito)'
if (extractFinalizeDescontado == extractEstado) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalizeDescontado) + ' ') + 'Y EL MONTO TOTAL DEL ESTADO DE LA ORDEN:') + 
        ' ') + extractEstado) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalizeDescontado) + ' ') + 'Y EL MONTO TOTAL DEL ESTADO DE LA ORDEN:') + 
        ' ') + extractEstado) + ' ') + 'NO COINCIDEN')
}

Mobile.tap(findTestObject('Object Repository/Finalizar Efectivo/android.view.ViewGroup - Desplegar detalle de orden 2'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

'obtiene monto total del detalle de orden de la cabecera'
String extractTotalDetallleCabecera = Mobile.getText(findTestObject('Object Repository/Finalizar Efectivo/android.widget.TextView - Total cabecera detalle 2'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total del detalle de orden (solo numero)'
println(extractTotalDetallleCabecera)

'validacion de monto total y descuento en detalle de orden de la cabecera'
if (extractFinalizeDescontado == extractTotalDetallleCabecera) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalizeDescontado) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN EN CABECERA:') + 
        ' ') + extractTotalDetallleCabecera) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalizeDescontado) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN EN CABECERA:') + 
        ' ') + extractTotalDetallleCabecera) + ' ') + 'NO COINCIDEN')
}

'obtiene monto descuento del detalle de orden'
String extractDescuentoDetalle = Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Descuento en detalle de orden'), 
    0).replaceAll('[^0-9]', '')

'imprime monto descuento en detalle de orden (solo numero)'
println(extractDescuentoDetalle)

'validacion de monto de descuento y descuento en detalle de orden'
if (extractCupon == extractDescuentoDetalle) {
    KeywordUtil.markPassed(((((((('EL PORCENTAJE DESCONTADO:' + ' ') + extractCupon) + ' ') + 'Y EL PORCENTAJE DESCONTADO EN EL DETALLE DE LA ORDEN:') + 
        ' ') + extractDescuentoDetalle) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL PORCENTAJE DESCONTADO:' + ' ') + extractCupon) + ' ') + 'Y EL PORCENTAJE DESCONTADO EN EL DETALLE DE LA ORDEN:') + 
        ' ') + extractDescuentoDetalle) + ' ') + 'NO COINCIDEN')
}

'obtiene monto total del detalle de orden'
String extractTotalDetallle = Mobile.getText(findTestObject('Object Repository/Finalizar con Cupon/android.widget.TextView - Total con descuento aplicado detalle de orden'), 
    0).replaceAll('[^0-9]', '')

'imprime monto total del detalle de orden (solo numero)'
println(extractTotalDetallle)

'validacion de monto total y descuento en detalle de orden'
if (extractFinalizeDescontado == extractTotalDetallle) {
    KeywordUtil.markPassed(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalizeDescontado) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN:') + 
        ' ') + extractTotalDetallle) + ' ') + 'COINCIDEN')
} else {
    KeywordUtil.markFailedAndStop(((((((('EL MONTO TOTAL DEL FINALIZE:' + ' ') + extractFinalizeDescontado) + ' ') + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN:') + 
        ' ') + extractTotalDetallle) + ' ') + 'NO COINCIDEN')
}

'atras para volver al estado de la orden'
Mobile.tap(findTestObject('Finalizar Efectivo/android.widget.TextView - Ir atras'), 0)

