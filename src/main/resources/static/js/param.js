var valorIndice;
var concepto;
var categoria;
var tipo;
var incr;

function guardarValor(n, c, cat) {
	valorIndice = parseFloat(n);
	concepto = parseInt(c);
	categoria = parseInt(cat - 1);
}

function asignarTipo(t) {
	tipo = t;
}

function asignarIncremento(inc) {
	incr = inc;
}

// function incrementar(id, n) {
// var periodos = [];
// var ids = [];
// $(".periodo").each(function(index) {
// periodos.push($(this).val());
// ids.push($(this).attr('id'));
// });
//
// var valor = valorIndice;
// var acu = valor;
//	
// ids.forEach(function(cod){
// document.getElementById(cod).value = parseFloat(acu) + parseFloat(n);
// acu = parseFloat(acu) + parseFloat(valor);
// });
// }

function incrementar(id, n) {
	var periodos = [];
	// var conceptos = [];

	$(".periodo").each(function(index) {
		periodos.push($(this).val());
	});
	//
	// $(".concepto").each(function(index) {
	// conceptos.push($(this).val());
	// });

	var valor = valorIndice;
	var acu = valor;
	var valAnt = 0;
	for (i = 1; i < periodos.length; i++) {
		var codigo = categoria + '' + concepto + '' + i;
		if (incr.startsWith('fijo')) {
			document.getElementById(codigo).value = parseFloat(acu)
					+ parseFloat(n);
			acu = parseFloat(acu) + parseFloat(valor);
		} else if (incr.startsWith('porc')) {
			if(valAnt == 0) {
				document.getElementById(codigo).value = parseFloat(n)
				+ (parseFloat(n) * parseFloat(acu / 100));
			} else {
				valAnt = parseFloat(valAnt)
				+ (parseFloat(valAnt) * parseFloat(acu / 100));
				document.getElementById(codigo).value = valAnt;
			}
		
			acu = parseFloat(acu) + parseFloat(valor);
		}
	}
}


//controlador del setTimeout
var controlador = null;

function alerta() {
	swal({
		title : 'Error de ingreso de datos',
		text : "Ingrese sólo números y punto decimal",
		type : 'warning',
		confirmButtonColor : '#ff0000',
		confirmButtonText : 'Ok'
	});
	
}


function alerta2(ident) {
	
		controlador = setTimeout(function() {document.getElementById(ident).value = "";document.getElementById(ident).focus();alerta();}, 1);

	
//	if (isNaN(valor)) {
//
//		setTimeout(function() {
//			document.getElementById(ident).select();
//		}, 0);
//		
//	}
}

// Descheckear radios...
var era;
var previo = null;
function uncheckRadio(rbutton) {
	if (previo && previo != rbutton) {
		previo.era = false;
	}
	if (rbutton.checked == true && rbutton.era == true) {
		rbutton.checked = false;
		incr = null;

	}
	rbutton.era = rbutton.checked;
	previo = rbutton;
}
