import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import LectorGetAllResponseDto from '../../dtos/Lector/getAll/LectorGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function LectorList() {
    const [LectorList, setLectorList] = useState<LectorGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Lector/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Lector List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Lector
          </Button></Grid>
        </Grid>

        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
<TableCell>NroSocio</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
{LectorList.length > 0 ? LectorList.map((row) => (
            <TableRow
              key={row.LectorId}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
                <TableCell component='th' scope='row'>
                       {row.NroSocio}
                </TableCell>
            </TableRow>
          )) : <p><strong>No hay registros para mostrar</strong></p>}
        </TableBody>
      </Table>
    </TableContainer>
    </Container>
)}
