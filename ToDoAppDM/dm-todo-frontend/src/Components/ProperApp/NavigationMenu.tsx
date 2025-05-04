import { Box, Button} from '@mui/material';
import { Link } from 'react-router-dom';

import { useContext } from 'react';
import { UserContext } from '../../Context/UserContext';

const NavigationMenu = () => {
     const userContext = useContext(UserContext);
      if (!userContext) {
      return <div>Błąd: brak UserProvider w drzewie komponentów</div>;
      }
      const { user, setUser } = userContext;

  return (
    <Box className="bg-gradient-to-t from-[var(--c6)] to-[var(--c6)] p-4 text-center">
      
      <Box 
        className="flex justify-center items-center gap-4 mt-4"
        sx={{ 
          maxWidth: '600px', 
          margin: '0 auto', 
          padding: '0.5rem',
          backgroundColor: 'rgba(255, 255, 255, 0.1)',
          borderRadius: '8px'
        }}
      >
        
        
        {user != 0 && <Button
          component={Link}
          to="/tasks"
          variant="contained"
          color="primary"
          sx={{ 
            flex: 1,
            fontWeight: 'bold',
            '&:hover': { transform: 'translateY(-2px)' },
            transition: 'transform 0.2s'
          }}
        >
          Tasks
        </Button> }
        {user == 0 && <Button
          component={Link}
          to="/tasksAdmin"
          variant="contained"
          color="primary"
          sx={{ 
            flex: 1,
            fontWeight: 'bold',
            '&:hover': { transform: 'translateY(-2px)' },
            transition: 'transform 0.2s'
          }}
        >
          Tasks
        </Button> }
        <Button
          component={Link}
          to="/products"
          variant="contained"
          color="primary"
          sx={{ 
            flex: 1,
            fontWeight: 'bold',
            '&:hover': { transform: 'translateY(-2px)' },
            transition: 'transform 0.2s'
          }}
        >
          Products
        </Button>
        <Button
          component={Link}
          to="/ItemsExpDate"
          variant="contained"
          color="primary"
          sx={{ 
            flex: 1,
            fontWeight: 'bold',
            '&:hover': { transform: 'translateY(-2px)' },
            transition: 'transform 0.2s'
          }}
        >
          check items
        </Button>
        <Button
          component={Link}
          to="/"
          variant="contained"
          color="error"
          
          sx={{ 
            marginLeft: 'auto',
            fontWeight: 'bold',
            '&:hover': { transform: 'translateY(-2px)' },
            transition: 'transform 0.2s'
          }}
          onClick={() =>setUser(-1)}
        >
          Log out
        </Button>
      
      </Box>
      
     
    </Box>
  );
};

export default NavigationMenu;