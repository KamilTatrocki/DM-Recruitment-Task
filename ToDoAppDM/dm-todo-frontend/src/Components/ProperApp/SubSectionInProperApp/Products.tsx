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

const Products = ({ products = [] }: { products: Product[] }) => {
  return (
    <div className="bg-radial from-[var(--c2)] to-[var(--c1)] min-h-screen">
      <Container>
      <div className="container mx-auto px-4">
        <div className="w-full h-full items-center">
          
          {products.length === 0 ? (
            <p className="text-center py-8">No Products found</p>
          ) : (
            <div className="flex flex-wrap gap-4 pt-4">
              {products.map((product) => (
                <div 
                  key={product.idProduct} 
                  className="w-48 h-48 flex flex-col justify-center items-center text-center bg-white rounded-md shadow-md p-4"
                >
                  <h3 className="text-lg font-medium text-gray-600">
                    {product.nameProduct}
                  </h3>
                  <p className="text-sm text-gray-500 mt-2">
                    {product.category?.name || 'No category'}
                  </p>
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
      </Container>
    </div>
  )
}

export default Products