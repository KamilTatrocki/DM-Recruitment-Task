import React, { createContext, useState } from 'react';

interface UserContextType {
  user: number;
  setUser: React.Dispatch<React.SetStateAction<number>>;
}

export const UserContext = createContext<UserContextType | null>(null);

export const UserProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [user, setUser] = useState<number>(-1);

  return (
    <UserContext.Provider value={{ user, setUser }}>
      {children}
    </UserContext.Provider>
  );
};
