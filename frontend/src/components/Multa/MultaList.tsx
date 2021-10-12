import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import MultaGetAllResponseDto from '../../dtos/Multa/getAll/MultaGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function MultaList() {
    const [MultaList, setMultaList] = useState<MultaGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Multa/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Multa List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Multa
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
{MultaList.length > 0 ? MultaList.map((row) => (
            <TableRow
              key={row.MultaId}
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
