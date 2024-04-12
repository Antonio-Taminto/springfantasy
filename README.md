<h1>Obiettivo: Creare un'applicazione web per la gestione dei personaggi in un mondo fantasy, con funzionalità di creazione, visualizzazione, modifica ed eliminazione dei personaggi.</h1>

<h3>
  
- Requisiti:

</h3>

   - Ogni personaggio deve avere un nome, una razza, una classe, un livello e una descrizione.

   - Le razze disponibili includono umani, elfi, nani e orchi.

   - Le classi disponibili includono guerrieri, maghi, ranger e ladri.

   - L'applicazione deve consentire agli utenti di:

     - Creare un nuovo personaggio, specificando nome, razza, classe e descrizione.
    
     - Visualizzare l'elenco completo dei personaggi.
    
     - Visualizzare i dettagli di un personaggio specifico.
    
     - Modificare i dettagli di un personaggio esistente.
    
     - Eliminare un personaggio dall'elenco.
    
   - L'applicazione deve includere un sistema di autenticazione per gli utenti.
  
   - I personaggi devono essere associati agli utenti che li hanno creati.
  
   - L'applicazione deve includere una funzionalità di ricerca per cercare personaggi per nome, razza o classe.
  
<h3>
  
- Implementazione:

</h3>

 - **Classe Character**
  
     - Attributi: id,nome,razza,livello,descrizione.
    
     - Metodi: getter e setter per tutti gli attributi.
  
   - **Classe CharacterService:**
    
     - Interfaccia contenente i metodi per la gestione dei personaggi.
      
   - **Metodi:**
    
     - List<Character> getAllCharacters(): Restituisce l'elenco completo dei personaggi.
      
     - Character getCharacterById(int id): Restituisce un personaggio specifico per ID
      
     - void createCharacter(Character character): Crea un nuovo personaggio.
      
     - void updateCharacter(int id, Character character): Aggiorna i dettagli di un personaggio esistente.
      
     - void deleteCharacter(int id): Rimuove un personaggio dall'elenco.
      
     - List<Character> searchCharacters(String keyword): Cerca personaggi per nome, razza o classe.
      
<h3>
  
- Classe CharacterController:

</h3>
  
   - **Controller per gestire le richieste HTTP relative ai personaggi.**
  
   - **Metodi:**
    
     - GET /characters: Restituisce l'elenco completo dei personaggi.
      
     - GET /characters/{id}: Restituisce i dettagli di un personaggio specifico.
      
     - POST /characters: Crea un nuovo personaggio.
      
     - PUT /characters/{id}: Aggiorna i dettagli di un personaggio esistente.
      
     - DELETE /characters/{id}: Rimuove un personaggio dall'elenco
      
     - GET /characters/search?keyword={keyword}: Cerca personaggi per nome, razza o classe.
      
<h3>
  
- Implementazione della logica di business nei metodi di CharacterService.

- Configurazione di Spring Security per l'autenticazione degli utenti.
  
- Configurazione di Spring Data JPA per l'interazione con il database.
</h3>
