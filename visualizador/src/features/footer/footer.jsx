import React from 'react';

//import 'bootstrap-icons/font/bootstrap-icons.css' from

const Footer = () => {
    const customBgColor = {
        backgroundColor: '#335C67' // Tu color verde oscuro
    };

    return (
        <footer className="text-white py-4 mt-auto" style={customBgColor}>
            <div className="container">
                <div className="row">

                    <div className="col-md-4 mb-3">
                        <h5>MetaMapa</h5>
                        <ul className="list-unstyled">
                            <li>
                                <a href="/acerca-de" className="text-white text-decoration-none opacity-75">
                                    Acerca de MetaMapa
                                </a>
                            </li>
                            <li>
                                <a href="/como-funciona" className="text-white text-decoration-none opacity-75">
                                    Cómo Funciona
                                </a>
                            </li>
                            <li>
                                <a href="/estadisticas" className="text-white text-decoration-none opacity-75">
                                    Estadísticas
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div className="col-md-4 mb-3">
                        <h5>Soporte</h5>
                        <ul className="list-unstyled">
                            <li>
                                <a href="/faq" className="text-white text-decoration-none opacity-75">
                                    Preguntas Frecuentes
                                </a>
                            </li>
                            <li>
                                <a href="/reportar-problema" className="text-white text-decoration-none opacity-75">
                                    Reportar un Problema
                                </a>
                            </li>
                            <li>
                                <a href="/contacto" className="text-white text-decoration-none opacity-75">
                                    Contacto
                                </a>
                            </li>
                        </ul>
                    </div>

                    {/* Columna 3: Legal */}
                    <div className="col-md-4 mb-3">
                        <h5>Legal</h5>
                        <ul className="list-unstyled">
                            <li>
                                <a href="/terminos" className="text-white text-decoration-none opacity-75">
                                    Términos y Condiciones
                                </a>
                            </li>
                            <li>
                                <a href="/privacidad" className="text-white text-decoration-none opacity-75">
                                    Política de Privacidad
                                </a>
                            </li>
                        </ul>
                    </div>

                </div>

                <hr className="opacity-100" />

                {/* Línea inferior: Copyright y Redes Sociales */}
                <div className="d-flex flex-column flex-sm-row justify-content-between align-items-center pt-3">
                    <p className="small mb-2 mb-sm-0">
                        &copy; {new Date().getFullYear()} MetaMapa. Todos los derechos reservados.
                    </p>

                    {/* Íconos de Redes Sociales (Ejemplo) */}
                    <ul className="list-inline mb-0">
                        <li className="list-inline-item">
                            <a href="https://twitter.com" className="text-white fs-4 opacity-75">
                                <i className="bi bi-twitter-x"></i>
                            </a>
                        </li>
                        <li className="list-inline-item ms-2">
                            <a href="https://facebook.com" className="text-white fs-4 opacity-75">
                                <i className="bi bi-facebook"></i>
                            </a>
                        </li>
                        <li className="list-inline-item ms-2">
                            <a href="https://instagram.com" className="text-white fs-4 opacity-75">
                                <i className="bi bi-instagram"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </footer>
    );
};

export default Footer;