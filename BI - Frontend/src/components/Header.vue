<template>
    <div>
        <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark" style="background: #2196F3;">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                    <div class="sidebar-brand-icon rotate-n-15"></div>
                    <div class="sidebar-brand-text mx-3"></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item">
                        <router-link to="/" class="nav-link"><i class="fas fa-tachometer-alt"></i><span>Dashboard</span></router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/productor" class="nav-link"><i class="fas fa-user"></i><span>Productor</span></router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/consumidor" class="nav-link"><i class="fas fa-user"></i><span>Consumidor</span></router-link>
                    </li>
                </ul>
                <div class="text-center d-none d-md-inline">
                    <button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
                </div>
            </div>
        </nav>
    </div>
</template>



