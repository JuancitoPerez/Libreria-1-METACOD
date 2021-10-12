import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import PrestamoGetAllResponseDto from '../../dtos/Prestamo/getAll/PrestamoGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function PrestamoList() {
    const [PrestamoList, setPrestamoList] = useState<PrestamoGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Prestamo/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Prestamo List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Prestamo
          </Button></Grid>
        </Grid>

        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
<TableCell>FechaInicio</TableCell>
<TableCell>FechaFin</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
{PrestamoList.length > 0 ? PrestamoList.map((row) => (
            <TableRow
              key={row.PrestamoId}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
                <TableCell component='th' scope='row'>
                       {row.FechaInicio}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.FechaFin}
                </TableCell>
            </TableRow>
          )) : <p><strong>No hay registros para mostrar</strong></p>}
        </TableBody>
      </Table>
    </TableContainer>
    </Container>
)}
