//$('#fecha1ercuota').val($('#fecha-prestamo').val());

//date = $.datepicker.parseDate(instance.settings.dateFormat, dateText,
//		instance.settings);
//date.setMonth(date.getMonth() + 6);
//$(".fecha1ercuota").datepicker("setDate", date);

// onSelect: function(dateText, instance) {
// date = $.datepicker.parseDate(instance.settings.dateFormat, dateText,
// instance.settings);
// date.setMonth(date.getMonth() + 6);
// $(".fecha1ercuota").datepicker("setDate", date);
// }
//	
//
// function editar_fecha(fecha, intervalo, dma, separador) {
//
// var separador = separador || "-";
// var arrayFecha = fecha.split(separador);
// var dia = arrayFecha[0];
// var mes = arrayFecha[1];
// var anio = arrayFecha[2];
//
// var fechaInicial = new Date(anio, mes - 1, dia);
// var fechaFinal = fechaInicial;
// if (dma == "m" || dma == "M") {
// fechaFinal.setMonth(fechaInicial.getMonth() + parseInt(intervalo));
// } else if (dma == "y" || dma == "Y") {
// fechaFinal
// .setFullYear(fechaInicial.getFullYear() + parseInt(intervalo));
// } else if (dma == "d" || dma == "D") {
// fechaFinal.setDate(fechaInicial.getDate() + parseInt(intervalo));
// } else {
// return fecha;
// }
// dia = fechaFinal.getDate();
// mes = fechaFinal.getMonth() + 1;
// anio = fechaFinal.getFullYear();
//
// dia = (dia.toString().length == 1) ? "0" + dia.toString() : dia;
// mes = (mes.toString().length == 1) ? "0" + mes.toString() : mes;
//
// return anio + "-" + mes + "-" + dia;
// }
