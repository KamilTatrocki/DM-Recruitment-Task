import React, { useState } from 'react'
import { Dialog, DialogTitle, DialogContent, Box, Button } from '@mui/material';

interface Category {
    id: number;
    name: string;
}
  
interface Product {
    idProduct: number;
    nameProduct: string;
    category: Category; 
}

interface Shelf{
    description: string;
    id: Number;
}

interface Task {
    description: string;
    idTask: Number;
    product?: Product;
    shelfFrom?: Shelf;
    shelfTo?:Shelf;
}

const TaskElement = ({task, isUser, isDone, idassigned,  funassigned, funtask }: {task: Task, isUser:Boolean, isDone:Boolean, idassigned:Number, funassigned: () => void, funtask: () => void }) => {
  const [open, setOpen] = useState(false);
  
  const handleOpen = () => {
    setOpen(true);
  };
  
  const handleClose = () => {
    setOpen(false);
  };

  const ChangeTaskStatus = async (newValue: Boolean) => {
    try {
       
      const response = await fetch(`http://localhost:8080/api/assigned/${idassigned}/done?value=${newValue}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        }
      });
      
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      
      funassigned()
      
    } catch (error) {
      console.error('Error updating task status:', error);
    }
  };
  const AssignTask = async (userId: Number) => {
    try {
      const taskId = task.idTask;
      
      const response = await fetch(`http://localhost:8080/api/assigned?taskId=${taskId}&userId=${userId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        }
      });
      
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      funtask();
      handleClose();
      
    } catch (error) {
      console.error('Error assigning task:', error);
    }
  };

  return (
    <div 
      className="w-64 h-auto min-h-48 flex flex-col justify-start items-center text-center bg-white rounded-md shadow-md p-4 border-l-4 border-[var(--c5)] mt-2 mb-2"
    >
      <h3 className="text-lg font-medium text-gray-700 mb-2">
        {task.description}
      </h3>
      
      {task.product && (
        <div className="mt-2 w-full">
          <p className="text-sm font-medium text-gray-600">Product:</p>
          <p className="text-sm text-gray-500">
            {task.product.nameProduct}
          </p>
        </div>
      )}
      
      {(task.shelfFrom || task.shelfTo) && (
        <div className="mt-2 w-full flex justify-between text-sm text-gray-500">
          {task.shelfFrom && (
            <div className="flex flex-col items-center">
              <span className="font-medium text-gray-600">From</span>
              <span>{task.shelfFrom.description}</span>
            </div>
          )}
          
          {task.shelfFrom && task.shelfTo && (
            <div className="flex items-center mx-2">→</div>
          )}
          
          {task.shelfTo && (
            <div className="flex flex-col items-center">
              <span className="font-medium text-gray-600">To</span>
              <span>{task.shelfTo.description}</span>
            </div>
          )}
        </div>
      )}
      
      <div className="mt-auto pt-2 w-full">
        {isUser ? (
          isDone ? (
            <Button 
              variant="contained" 
              color="success"
              className="w-full mt-2"
              onClick={()=> ChangeTaskStatus(false)}
            >
              Done - Click to Undo
            </Button>
          ) : (
            <Button 
              variant="contained" 
              color="error"
              className="w-full mt-2"
              onClick={()=> ChangeTaskStatus(true)}
            >
              Mark as Done
            </Button>
          )
        ) : (
          <Button 
            variant="contained" 
            color="primary"
            className="w-full mt-2"
            onClick={handleOpen}
          >
            Assign Task
          </Button>
        )}

        <Dialog open={open} onClose={handleClose}>
          <DialogTitle color='textSecondary'>Assign Task</DialogTitle>
          <DialogContent>
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
                color="primary"
                className="mt-4"
                fullWidth
                onClick={()=>{AssignTask(2)}}
              >
                Assign to User 1
              </Button>
              
              <Button
                variant="contained"
                color="primary"
                className="mt-4"
                fullWidth
                onClick={()=>{AssignTask(3)}}
              >
                Assign to User 2
              </Button>
              
              <Button
                variant="contained"
                color="secondary"
                onClick={handleClose}
                className="mt-4"
                fullWidth
              >
                Cancel
              </Button>
            </Box>
          </DialogContent>
        </Dialog>
        
        <p className="text-xs text-gray-400 text-right mt-2">
          ID: {task.idTask.toString()}
        </p>
      </div>
    </div>
  )
}

export default TaskElement
