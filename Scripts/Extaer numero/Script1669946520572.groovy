import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.util.KeywordUtil as FailureHandling

Mobile.startExistingApplication('com.artico.delivery.pedidos')

not_run: Mobile.tap(findTestObject('Object Repository/Prueba extaer numero/android.view.ViewGroup'), 0)

not_run: Mobile.tap(findTestObject('Object Repository/Prueba extaer numero/android.widget.ImageView'), 0)

String extractInt1 = Mobile.getText(findTestObject('Finalizar POS/android.widget.TextView - Total finalize'), 0).replaceAll("[^0-9]", "")

println(extractInt1)

not_run: String extractInt2 = Mobile.getText(findTestObject('Prueba extaer numero/android.widget.TextView - Monto Total abajo derecha'), 0).replaceAll(
    '[^0-9.]', '')

not_run: println(extractInt2)

not_run: if (extractInt1 == extractInt2) {
	
	KeywordUtil.markPassed('EL MONTO TOTAL DEL FINALIZE' + ' ' +extractInt1+ ' ' + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN.' + 
		' ' +extractInt2+ ' ' + 'COINCIDEN CORRECTAMENTE')
}else {
    KeywordUtil.markFailedAndStop('EL MONTO TOTAL DEL FINALIZE' + ' ' +extractInt1+ ' ' + 'Y EL MONTO TOTAL DEL DETALLE DE LA ORDEN.' + 
		' ' +extractInt2+ ' ' + 'NO COINCIDEN')
}