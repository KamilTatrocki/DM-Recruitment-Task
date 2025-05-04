
import { useState , useContext} from 'react';

import { Box, Typography, Button, Dialog, DialogContent, DialogTitle } from '@mui/material';
import  Image from '../../assets/Dm-logo.svg'
import { UserContext } from '../../Context/UserContext';
const Top = () => {
    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const userContext = useContext(UserContext);
    if (!userContext) {
    return <div>Błąd: brak UserProvider w drzewie komponentów</div>;
    }
    const {  setUser } = userContext;

  return (
    <>
    <Box className="bg-gradient-to-b from-[var(--c6)] to-[var(--c5)]  p-12 text-center items-center ">
          
          <img src={Image} className='h-16 mx-auto'></img>
          
          <Typography variant="h3" className="text-white">
            Task Manager
          </Typography>
         

        
        <Typography  sx={{ marginTop: '0.25rem', marginBottom:'0.5rem', color: 'var(--c3)' }} >
          Recruitment Task by Kamil Tatrocki
        </Typography>
        <Button variant="contained" color="primary" onClick={handleOpen} className="mt-8">
          Launch the app
        </Button>
      </Box>
     
      <Dialog  open={open} onClose={handleClose}>
        <DialogTitle color='textSecondary'>Login Panel</DialogTitle>
        <DialogContent >
          <Box
            display="flex"
            flexDirection="column"
            justifyContent="center"
            alignItems="center"
            height="100%"
            minWidth={200}
            gap={2}
          >
          
            <Button
              variant="contained"
              color="secondary"
              onClick={()=>{setUser(1)}}
              className="mt-4"
              fullWidth
            >
              Login as User1
            </Button>
            <Button
              variant="contained"
              color="secondary"
              onClick={()=>{setUser(2)}}
              className="mt-4"
              fullWidth
            >
              Login as User2
            </Button>

            <Button
              variant="contained"
              color="secondary"
              onClick={()=>{setUser(0)}}
              className="mt-4"
              fullWidth
            >
              Login As Admin
            </Button>

            <Button
              variant="contained"
              color="secondary"
              onClick={handleClose}
              className="mt-4"
              fullWidth
            >
              Exit
            </Button>
          </Box>
        </DialogContent>
      </Dialog>
        


    </>
  )
}

export default Top