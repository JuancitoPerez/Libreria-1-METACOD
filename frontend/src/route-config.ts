
import PersonaList from './components/Persona/PersonaList';
import PersonaCreate from './components/Persona/PersonaCreate';
import AutorList from './components/Autor/AutorList';
import AutorCreate from './components/Autor/AutorCreate';
import CopiaList from './components/Copia/CopiaList';
import CopiaCreate from './components/Copia/CopiaCreate';
import LibroList from './components/Libro/LibroList';
import LibroCreate from './components/Libro/LibroCreate';
import LectorList from './components/Lector/LectorList';
import LectorCreate from './components/Lector/LectorCreate';
import MultaList from './components/Multa/MultaList';
import MultaCreate from './components/Multa/MultaCreate';
import PrestamoList from './components/Prestamo/PrestamoList';
import PrestamoCreate from './components/Prestamo/PrestamoCreate';

const routes = [
{path: '/Persona/all', componente: PersonaList },
{path: '/Persona/create', componente: PersonaCreate },
{path: '/Autor/all', componente: AutorList },
{path: '/Autor/create', componente: AutorCreate },
{path: '/Copia/all', componente: CopiaList },
{path: '/Copia/create', componente: CopiaCreate },
{path: '/Libro/all', componente: LibroList },
{path: '/Libro/create', componente: LibroCreate },
{path: '/Lector/all', componente: LectorList },
{path: '/Lector/create', componente: LectorCreate },
{path: '/Multa/all', componente: MultaList },
{path: '/Multa/create', componente: MultaCreate },
{path: '/Prestamo/all', componente: PrestamoList },
{path: '/Prestamo/create', componente: PrestamoCreate },]
export default routes;
