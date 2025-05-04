import { Container } from '@mui/material'
import TaskElement from '../../Basic/TaskElement';
import { useContext } from 'react';
import { UserContext } from '../../../Context/UserContext';

interface Shelf {
    id: number;
    description: string;
  }
  
  interface Product {
    idProduct: number;
    nameProduct: string;
    category: any; 
  }
  
  interface Task {
    idTask: number;
    description: string;
    product?: Product; 
    shelfFrom?: Shelf;
    shelfTo?: Shelf; 
  }

  interface AssignedTask {
    idAssigned: number;
    done: boolean;
    task: Task;          
    user: {
      idUser: Number;
      login: string;
      password: string;
    }
  }
  


  const TasksUser = ({ tasks = [], funassigned, funtask }: { tasks: AssignedTask[], funassigned: () => void, funtask: () => void }    ) => {

  const userContext = useContext(UserContext);
  if (!userContext) {
  return <div>Błąd: brak UserProvider w drzewie komponentów</div>;
  }
  const { user } = userContext;
  const tasksForCurrentUser = tasks.filter(t => t.user.idUser == (user+1)).map(t => ({ ...t.task, done: t.done, IDASSIGNEDTASK: t.idAssigned })).sort((a, b) => {
    if (a.done === false && b.done === true) return -1;
    if (a.done === true && b.done === false) return 1;
    return 0; 
  });
  
  let isUserVar;
  if (user ==0)
     isUserVar=false
  else
    isUserVar=true
  
  return (
    
    <div className='bg-radial from-[var(--c2)] to-[var(--c1)] min-h-screen'>
      <Container>
        <div className='w-full h-full items-center'>
          
          {tasksForCurrentUser.length === 0 ? (
            <p>No tasks found</p>
          ) : (
            <ul>
              {tasksForCurrentUser.map((task, index) => (
                  
                <li key={ index} style={{ display: 'inline-block', margin: '0 10px' }}>
                  <TaskElement task={task} isDone={task.done} isUser={isUserVar} idassigned={task.IDASSIGNEDTASK} funassigned={funassigned} funtask={funtask}/>
                </li>
              ))}
            </ul>
          )}
        </div>
      </Container>
    </div>
  )
}

export default TasksUser