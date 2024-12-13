<template>
    <body id="page-top">
    <div id="wrapper">
        <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark" style="background: #2196F3;">
        <Header/>
        </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
                <Navbar/>
                <div class="container">
                    <h2 style="border-color: black;">Consumidor</h2>
                    <div class="card shadow">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 fw-bold">Consumidores Registrados</p>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6 text-nowrap">
                                    <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable"><label class="form-label">Show&nbsp;<select class="d-inline-block form-select form-select-sm">
                                                <option value="10" selected="">10</option>
                                                <option value="25">25</option>
                                                <option value="50">50</option>
                                            </select>&nbsp;</label></div>
                                </div>
                                <div class="col-md-6">
                                    <div class="text-md-end dataTables_filter" id="dataTable_filter"><label class="form-label"><input type="search" class="form-control form-control-sm" aria-controls="dataTable" placeholder="Search"></label></div>
                                </div>
                            </div>
                            <div class="table-responsive table mt-2" id="dataTable-1" role="grid" aria-describedby="dataTable_info">
                                <table class="table my-0" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Correo</th>
                                            <th>Ubicación</th>
                                            <th>Tipo Energía</th>
                                            <th>Recomendación</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="(item, index) in data" :key="index">
                                            <td>{{ item.nombre }}</td>
                                            <td>{{ item.apellido }}</td>
                                            <td>{{ item.correo }}</td>
                                            <td>{{ item.ubicacion }}</td>
                                            <td>{{ item.tipoEnergia }}</td>
                                            <td>{{ item.recomendacionConsumo }}</td>
                                            <td style="padding: 0px;" class="pb-0">
                                                <button 
                                                    class="btn btn-primary" 
                                                    type="button" 
                                                    style="margin: 5px; background: #2196f3; border-style: none;" 
                                                    @click="editarConsumidor(item)"
                                                >
                                                    Editar
                                                </button>
                                                <button 
                                                    class="btn btn-primary" 
                                                    type="button" style="margin: 
                                                    5px;background: var(--bs-danger);
                                                    border-style: none;"
                                                    @click="eliminarConsumidor(item.codigoConsumidor)"
                                                >
                                                    Eliminar
                                                </button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div
                                    class="d-flex justify-content-center align-items-center"
                                    v-if="cargarDatos"
                                >
                                    <img src="../assets/img/carga.gif" alt="Cargando..."  />
                                </div>
                            </div>
                        </div>
                    </div>
                    <button 
                        class="btn btn-primary" 
                        type="button" 
                        style="margin: 10px; border-style: none; border-color: var(--bs-success); background: var(--bs-success); padding: 6px 40px;" 
                        @click="mostrarFormularioInsertar"
                    >
                        Insertar
                    </button>
                </div>
                <div v-if="mostrarFormulario" class="container">
                    <section class="position-relative py-4 py-xl-5">
                        <h2 style="border-color: black;">Consumidor</h2>
                        <div class="container position-relative">
                            <div class="row d-flex justify-content-center">
                                <div class="col-md-8 col-lg-6 col-xl-5 col-xxl-4">
                                    <div class="card mb-5">
                                        <div class="card-body p-sm-5">
                                            <h3 class="text-center mb-4">{{ esEdicion ? 'Editar Consumidor' : 'Registrar Consumidor' }}</h3>
                                            <form @submit.prevent="insertarConsumidor">
                                                <div class="mb-3"><input class="form-control" type="number" require v-model="form.codigoConsumidor" id="codigo" name="codigo" placeholder="Código"></div>
                                                <div class="mb-3"><input class="form-control" type="number" require v-model="form.documento" id="documento" name="documento" placeholder="Documento"></div>
                                                <div class="mb-3"><input class="form-control" type="text" require v-model="form.nombre" id="nombre" name="nombre" placeholder="Nombre"></div>
                                                <div class="mb-3"><input class="form-control" type="text" require v-model="form.apellido" id="apellido" name="apellido" placeholder="Apellido"></div>
                                                <div class="mb-3"><input class="form-control" type="text" require v-model="form.correo" id="correo" name="correo" placeholder="Correo"></div>
                                                <div class="mb-3"><input class="form-control" type="password" require v-model="form.contrasenia" id="contrasenia" name="contrasenia" placeholder="Contraseña"></div>

                                                <div class="mb-3"><input class="form-control" type="text" require v-model="form.ubicacion" id="ubicación" name="ubicación" placeholder="Ubicación"></div>
                                                <div class="mb-3"><input class="form-control" type="text" require v-model="form.tipoEnergia" id="tipoEnergía" name="tipoEnergía" placeholder="Tipo Energía"></div>
                                                <div class="mb-3"><input class="form-control" type="number" require v-model="form.mesConsumido" id="mesConsumido" name="mesConsumido" placeholder="Mes consumido"></div>
                                                <div class="mb-3"><input class="form-control" type="text" require v-model="form.recomendacionConsumo" id="recomendacion" name="recomendacion" placeholder="Recomendación"></div>
                                                <div class="mb-3"><input class="form-control" type="number" require v-model="form.reporteConsumo" id="reporte" name="reporte" placeholder="ReporteConsumo"></div>
                                                
                                                <div><button class="btn btn-primary d-block w-100" type="submit"> {{ esEdicion ? 'Actualizar' : 'Registrar' }}</button></div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
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
import Swal from 'sweetalert2';
import { onMounted, ref } from 'vue';

// Funcion para listar consumidores

const data = ref([]);
const cargarDatos = ref(true);
const mensaje = ref(null);
const mostrarFormulario = ref(false);
const esEdicion = ref(false); 

const listarConsumidores = async () => {
    try {
        const respuesta = await fetch("http://localhost:8080/consumidor");
        if (!respuesta.ok) {
            throw new Error("Datos no listados");
        }
        data.value = await respuesta.json();
    } catch (error) {
        mensaje.value = error.message;
    } finally {
        cargarDatos.value = false;
    }
};

onMounted(() => {
    listarConsumidores();
});


const mostrarFormularioInsertar = () => {
    esEdicion.value = false; 
    limpiarFormulario();
    mostrarFormulario.value = true;
};

const form = ref({
    codigoConsumidor: "",
    documento: "",
    nombre: "",
    apellido: "",
    correo: "",
    contrasenia: "",
    mesConsumido: "",
    ubicacion: "",
    tipoEnergia: "",
    recomendacionConsumo: "",
    reporteConsumo: "",
});

// Funcion para limpiar el formulario

const limpiarFormulario = () => {
    form.value = {
        codigoConsumidor: "",
        documento: "",
        nombre: "",
        apellido: "",
        correo: "",
        contrasenia: "",
        mesConsumido: "",
        ubicacion: "",
        tipoEnergia: "",
        recomendacionConsumo: "",
        reporteConsumo: "",
    };
};


// Funcion para insertar un consumidor nuevo 

const insertarConsumidor = async () => {
    try {
        const url = esEdicion.value 
            ? `http://localhost:8080/consumidor/actualizar/${form.value.codigoConsumidor}`
            : "http://localhost:8080/consumidor";
        const method = esEdicion.value ? "PUT" : "POST";

        const respuesta = await fetch(url, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(form.value),
        });

        if (!respuesta.ok) {
            throw new Error(
                esEdicion.value 
                    ? "Error al actualizar el consumidor" 
                    : "Error al registrar el consumidor"
            );
        }

        Swal.fire({
            title: esEdicion.value ? "Actualización Exitosa" : "Registro Exitoso",
            text: esEdicion.value 
                ? "Consumidor actualizado correctamente" 
                : "Consumidor registrado correctamente",
            icon: "success",
            confirmButtonText: "Aceptar",
        }).then(() => {
            mostrarFormulario.value = false;
            listarConsumidores();
        });

    } catch (error) {
        Swal.fire({
            title: "Error",
            text: error.message,
            icon: "error",
            confirmButtonText: "Aceptar",
        });
    }
};


// Funcion para editar un consumidor

const editarConsumidor = (consumidor) => {
    form.value = { ...consumidor }; 
    esEdicion.value = true; 
    mostrarFormulario.value = true;
};



// Funcion para eliminar un consumidor

const eliminarConsumidor = async (consumidor) => {

    try {
        
        const confirmacion = await Swal.fire({
            title: "¿Estás seguro?",
            text: "No podrás deshacer esta acción.",
            icon: "warning",
            showCancelButton: true,
            cancelButtonText: "Cancelar",
            confirmButtonText: "Sí, eliminar",
        });

        if (!confirmacion.isConfirmed) {
            return; 
        }

        const respuesta = await fetch(`http://localhost:8080/consumidor/eliminar/${consumidor}`,
        {
            method: "DELETE"
        }
        );

        if( !respuesta.ok ) {
            throw new Error("Error al eliminar el consumidor");
        }

        Swal.fire({
            title: "Eliminado Correctamente!",
            icon: "success",
            confirmButtonText: "Aceptar", 
        }).then(() => {
            listarConsumidores();
        })

    } catch (error) {
        console.error(error.message);
        Swal.fire({
            title: "No eliminado!",
            text: "El cliente no fue eliminado",
            icon: "error",
            confirmButtonText: "Aceptar", 
        })
    }
}

</script>
