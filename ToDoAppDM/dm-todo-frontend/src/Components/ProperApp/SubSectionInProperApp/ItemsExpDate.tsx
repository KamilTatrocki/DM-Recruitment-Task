import { Container } from '@mui/material';
import React from 'react'

interface Category {
  id: number;
  name: string;
}

interface Product {
  idProduct: number;
  nameProduct: string;
  category: Category; 
}

interface Item {
  idItem: number;
  expirationDate: Date;
  product: Product;
}

const ItemsExpDate = ({ items = [] }: { items: Item[] }) => {
 
  const formatDate = (dateString:Date) => {
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'short',
      day: 'numeric'
    });
  };

  
  const getDaysUntilExpiration = (dateString:Date) => {
    const today = new Date();
    const expDate = new Date(dateString);
    const diffTime = expDate.getTime() - today.getTime();
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    return diffDays;
  };

  return (
    <div className="bg-radial from-[var(--c2)] to-[var(--c1)] min-h-screen">
        <Container>
    
      <div className="container mx-auto px-4">
        <div className="w-full h-full items-center">
          
          
          {items.length === 0 ? (
            <p className="text-center py-8">No Items found</p>
          ) : (
            <div className="flex flex-wrap gap-4 pt-4">
              {items.map((item) => {
                const daysUntil = getDaysUntilExpiration(item.expirationDate);
                let borderColor = "border-green-500";
                
               
                if (daysUntil < 0) {
                  borderColor = "border-red-600"; 
                } else if (daysUntil < 7) {
                  borderColor = "border-orange-500"; 
                } else if (daysUntil < 30) {
                  borderColor = "border-yellow-500"; 
                }
                
                return (
                  <div 
                    key={item.idItem} 
                    className={`w-48 h-48 flex flex-col justify-center items-center text-center bg-white rounded-md shadow-md p-4 border-l-4 ${borderColor}`}
                  >
                    <h3 className="text-lg font-medium text-gray-600">
                      {item.product.nameProduct}
                    </h3>
                    <p className="text-sm text-gray-500 mt-2">
                      {item.product.category?.name || 'No category'}
                    </p>
                    
                    <div className="mt-auto pt-2">
                      <p className="text-xs font-medium">Expires on:</p>
                      <p className={`font-medium ${daysUntil < 0 ? 'text-red-600' : daysUntil < 7 ? 'text-orange-500' : 'text-gray-700'}`}>
                        {formatDate(item.expirationDate)}
                      </p>
                      
                      {daysUntil < 0 ? (
                        <p className="text-xs text-red-600 mt-1">Expired</p>
                      ) : (
                        <p className="text-xs text-gray-500 mt-1">{daysUntil} days left</p>
                      )}
                    </div>
                  </div>
                );
              })}
            </div>
          )}
        </div>
      </div>
    
    </Container>
    </div>
  )
}

export default ItemsExpDate