import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import PersonaGetAllResponseDto from '../../dtos/Persona/getAll/PersonaGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function PersonaList() {
    const [PersonaList, setPersonaList] = useState<PersonaGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Persona/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Persona List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Persona
          </Button></Grid>
        </Grid>

        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
<TableCell>Nombre</TableCell>
<TableCell>Apellido</TableCell>
<TableCell>FechaNacimiento</TableCell>
<TableCell>Nacionalidad</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
{PersonaList.length > 0 ? PersonaList.map((row) => (
            <TableRow
              key={row.PersonaId}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
                <TableCell component='th' scope='row'>
                       {row.Nombre}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.Apellido}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.FechaNacimiento}
                </TableCell>
                <TableCell component='th' scope='row'>
                       {row.Nacionalidad}
                </TableCell>
            </TableRow>
          )) : <p><strong>No hay registros para mostrar</strong></p>}
        </TableBody>
      </Table>
    </TableContainer>
    </Container>
)}
