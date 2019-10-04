/**
 * 
 */
// Calculos de hora de Estado Patrimonial:
// @ander - 5-dic-2018
var totalActivo = 0.00;
var totalPasivo = 0.00;
var totalPatrimonio = 0.00;
var totalIngresos = 0.00;
var totalGastos = 0.00;
var totalCuentas = 0.00;

function sumarActivo(valor, rubro, grupo) {

	if (rubro === 1 && grupo === 1) {
		totalActivo += parseFloat(valor);
		$('#monto_activo').text('$' + totalActivo.toFixed(2));
	} else if (rubro === 2 && grupo === 1) {
		totalPasivo += parseFloat(valor);
		$('#monto_pasivo').text('$' + totalPasivo.toFixed(2));
	} else if (rubro === 3 && grupo === 1) {
		totalPatrimonio += parseFloat(valor);
		$('#monto_patrimonio').text('$' + totalPatrimonio.toFixed(2));
	} else if (rubro === 1 && grupo === 2) {
		totalIngresos += parseFloat(valor);
		$('#monto_ingresos').text('$' + totalIngresos.toFixed(2));
	} else if (rubro === 2 && grupo === 2) {
		totalGastos += parseFloat(valor);
		$('#monto_gastos').text('$' + totalGastos.toFixed(2));
	} else if (rubro === 3 && grupo === 2) {
		totalCuentas += parseFloat(valor);
		$('#monto_cuentas').text('$' + totalCuentas.toFixed(2));
	}

}




//
//$("#iniact").datepicker( {
//    format: "mm-yyyy",
//    startView: "months", 
//    minViewMode: "months"
//});

//
// $(document).ready(function() {
// var s = $('#monto').val().replace('.', /\,/g);
// $('#monto').attr('type', 'number');
// $('#monto').val(s);
// });
//
// function reemplazarPuntoPorComa() {
// var s = $('#monto').val().replace('.', ',');
// //$('#monto').attr('type', 'number');
// $('#monto').val(s);
// }
