import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import LibroGetAllResponseDto from '../../dtos/Libro/getAll/LibroGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function LibroList() {
    const [LibroList, setLibroList] = useState<LibroGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Libro/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Libro List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Libro
          </Button></Grid>
        </Grid>

        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
<TableCell>Titulo</TableCell>
<TableCell>Genero</TableCell>
<TableCell>Editorial</TableCell>
<TableCell>FechaPublicación</TableCell>
<TableCell>Fecha</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
{LibroList.length > 0 ? LibroList.map((row) => (
            <TableRow
              key={row.LibroId}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
                <TableCell component='th' scope='row'>
                       {row.Titulo}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.Genero}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.Editorial}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.FechaPublicación}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.Fecha}
                </TableCell>
            </TableRow>
          )) : <p><strong>No hay registros para mostrar</strong></p>}
        </TableBody>
      </Table>
    </TableContainer>
    </Container>
)}
