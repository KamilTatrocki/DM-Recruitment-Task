

const Footer = () => {
  return (
    <footer className="bg-[var(--c6)]  text-white text-center py-4">
      <div className="container mx-auto">
        <p className="text-sm">&copy; {new Date().getFullYear()}  Created by Kamil Tatrocki.</p>
        <nav className="mt-2">
          <ul className="flex justify-center space-x-4">
            <li>
              <a href="https://www.dm.pl/" className="hover:underline">DM Site</a>
            </li>
            
            <li>
              <a href="https://play.google.com/store/apps/details?id=de.dm.meindm.android&hl=pl" className="hover:underline">Download DM App</a>
            </li>
          </ul>
        </nav>
      </div>
    </footer>
  );
};

export default Footer;