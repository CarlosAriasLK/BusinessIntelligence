<template>

    <body id="page-top">
        <div id="wrapper">
            <Header />

            <div class="d-flex flex-column" id="content-wrapper">
                <div id="content">
                    <Navbar />
                    <div class="container-fluid">
                        <div class="d-sm-flex justify-content-between align-items-center mb-4">
                            <h3 class="text-dark mb-0">Dashboard</h3><a
                                class="btn btn-primary btn-sm d-none d-sm-inline-block" role="button" href="#"><i
                                    class="fas fa-download fa-sm text-white-50"></i>&nbsp;Generar Reporte</a>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-xl-3 mb-4">
                                <div class="card shadow border-left-primary py-2">
                                    <div class="card-body">
                                        <div class="row g-0 align-items-center">
                                            <div class="col me-2">
                                                <div class="text-uppercase text-primary fw-bold text-xs mb-1">
                                                    <span>Productores</span></div>
                                                <div class="text-dark fw-bold h5 mb-0"><span>{{ productoresCount }}</span></div>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-xl-3 mb-4">
                                <div class="card shadow border-left-success py-2">
                                    <div class="card-body">
                                        <div class="row g-0 align-items-center">
                                            <div class="col me-2">
                                                <div class="text-uppercase text-success fw-bold text-xs mb-1">
                                                    <span>Consumidores</span></div>
                                                <div class="text-dark fw-bold h5 mb-0"><span>{{ consumidoresCount }}</span></div>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-5 col-xl-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header d-flex justify-content-between align-items-center">
                                        <h6 class="text-primary fw-bold m-0">Gráfico de Torta</h6>
                                    </div>
                                    <div class="card-body" style="height: 372px;">
                                        <div class="chart-area" style="height: 300px;">
                                            <canvas
                                                data-bss-chart='{
                                                    "type":"doughnut",
                                                    "data":{
                                                        "labels":["Color 1","Color 2"],
                                                        "datasets":[{
                                                            "label":"",
                                                            "backgroundColor":["#2ecc71","#45a29e"],
                                                            "borderColor":["#ffffff","#ffffff"],
                                                            "data":[50, 50]
                                                        }]
                                                    },
                                                    "options":{
                                                        "maintainAspectRatio":false,
                                                        "legend":{"display":false,"labels":{"fontStyle":"normal"}},
                                                        "title":{"fontStyle":"normal"}
                                                    }
                                                }'>
                                            </canvas>
                                        </div>
                                        <div class="text-center small mt-4" style="margin: 12px initial;"><span
                                                class="me-2"><i
                                                    class="fas fa-circle text-success"></i>&nbsp;Consumido</span><span
                                                class="me-2"><i
                                                    class="fas fa-circle text-success-dark"></i>&nbsp;Producido</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-xl-7 mb-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="text-primary fw-bold m-0">Energías</h6>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="small fw-bold">Heolica<span class="float-end">20%</span></h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar bg-danger" aria-valuenow="20" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 20%;"><span
                                                    class="visually-hidden">20%</span></div>
                                        </div>
                                        <h4 class="small fw-bold">Solar<span class="float-end">40%</span></h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar bg-warning" aria-valuenow="0" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 40%;"><span
                                                    class="visually-hidden">40%</span></div>
                                        </div>
                                        <h4 class="small fw-bold">Hidroeléctrica<span class="float-end">30%</span></h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar bg-primary" aria-valuenow="60" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 30%;"><span
                                                    class="visually-hidden">60%</span></div>
                                        </div>
                                        <h4 class="small fw-bold">Geotérmica<span class="float-end">80%</span></h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar bg-info" aria-valuenow="80" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 70%;"><span
                                                    class="visually-hidden">80%</span></div>
                                        </div>
                                        <h4 class="small fw-bold">Biomasa<span class="float-end">50%</span></h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar bg-success" aria-valuenow="100" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 50%;"><span
                                                    class="visually-hidden">100%</span></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="bg-white sticky-footer">
                    <div class="container my-auto">
                        <div class="text-center my-auto copyright"><span>Copyright © EcoNova 2024</span></div>
                    </div>
                </footer>
            </div>

        </div>
    </body>
</template>

<script setup>
import Header from '@/components/Header.vue';
import Navbar from '@/components/Navbar.vue';
import { ref, onMounted } from 'vue';


// Función para contar los productores

const productoresCount = ref(0);
const mensaje = ref(null);

const contarProductores = async () => {
    try {
        const respuesta = await fetch("http://localhost:8080/productor/contar");
        if (!respuesta.ok) {
            throw new Error("Datos no encontrados");
        }

        productoresCount.value = await respuesta.json();
    } catch (error) {
        mensaje.value = error.message;
        console.error("Error al sincronizar los productores:", error);
    }
};

onMounted(contarProductores);



// Funcion para contar los consumidores

const consumidoresCount = ref(0);
const numero = 1;

const contarConsumidores = async () => {
    try {
        const respuesta = await fetch("http://localhost:8080/consumidor/contar");
        if (!respuesta.ok) {
            throw new Error("Datos no encontrados");
        }

        consumidoresCount.value = await respuesta.json();
    } catch (error) {
        mensaje.value = error.message;
        console.error("Error fetching producers count:", error);
    }
};

onMounted(contarConsumidores);



// Funcion para obtener el porcentaje del gráfico

const porcentajeConsumo = ref(0);
const porcentajeProduccion = ref(0);

const energiaConsumidaTotal = ref(0);
const energiaProducidaTotal = ref(0);

const calcularPorcentajes = () => {
    const totalEnergia = energiaConsumidaTotal.value + energiaProducidaTotal.value;
    
    if (totalEnergia > 0) {
        porcentajeConsumo.value = Math.round((energiaConsumidaTotal.value / totalEnergia) * 100);
        porcentajeProduccion.value = Math.round((energiaProducidaTotal.value / totalEnergia) * 100);
    } else {
        porcentajeConsumo.value = 0;
        porcentajeProduccion.value = 0;
    }
};


const obtenerSumaEnergiaConsumida = async () => {
    try {
        const respuesta = await fetch("http://localhost:8080/energiaconsumida/suma-energia");
        if (!respuesta.ok) {
            throw new Error("No se pudo obtener la suma de energía consumida");
        }
        energiaConsumidaTotal.value = await respuesta.json();
        calcularPorcentajes()
    } catch (error) {
        mensaje.value = error.message;
        console.error("Error al obtener suma de energía consumida:", error);
    }
    console.log("Energia total consumida",energiaConsumidaTotal.value);
};


const obtenerSumaEnergiaProducida = async () => {
    try {
        const respuesta = await fetch("http://localhost:8080/energiaproducida/suma-energia");
        if( !respuesta.ok ) {
            throw new Error("No se pudo obtener la suma de energía producida");
        }
        energiaProducidaTotal.value = await respuesta.json();
        calcularPorcentajes()
    } catch (error) {
        mensaje.value = error.message;
        console.error("Error al obtener la suma de energía producida", error);        
    }
    console.log("Energia total producida", energiaProducidaTotal.value);
}

onMounted( () => {
    obtenerSumaEnergiaConsumida();
    obtenerSumaEnergiaProducida(); 
});

</script>
