import { Outlet } from 'react-router-dom';
import NavBar from '../../components/nav-bar/nav-bar.jsx';
import Footer from '../../features/footer/footer.jsx';


function Layout() {
    return (
        <section className="app-layout">
            <NavBar />
            <main className="app-content">
                <Outlet/>
            </main>
            <Footer />
        </section>
    )
}

export default Layout;