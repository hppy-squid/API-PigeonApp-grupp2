# API-PigeonApp-grupp2

# PigeonApp

PigeonApp är APIet till ett grupprojekt byggt med Spring Boot och MongoDB för att hantera projekt, medlemmar och issues (arbetsuppgifter). Applikationen erbjuder ett REST API för att skapa och hantera projekt, tilldela medlemmar och följa upp arbetsuppgifter.

## Funktionalitet

- **Projekt**: Skapa nya projekt, hämta aktiva och avslutade projekt.
- **Medlemmar**: Lägg till medlemmar i projekt, hämta alla medlemmar eller medlemmar kopplade till ett specifikt projekt.
- **Issues**: Skapa nya issues kopplade till projekt, hämta issues baserat på status (aktiva, inaktiva, klara).
- **TidsEstimering**: Lägg eran uppskatttade tid för issuet( alla melemmar måste lägga för att kunna aktivera issuet).
- **Tidsbokföring** : Lägg till den riktiga tiden issuet tog för att kunna se en bra statistik över projektets issue.
- **Statistik**: Se statistik för projektets issue.

## Teknologier

- Java 21
- Spring Boot
- MongoDB
- Lombok
- java-dotenv (för miljövariabler)

## Komma igång

### Förutsättningar

- Java 21 installerat
- MongoDB instans (lokalt eller i molnet)
- Maven

### Installation

1. Klona detta repo:

   ```sh
   git clone https://github.com/hppy-squid/API-PigeonApp-grupp2
   cd API-PigeonApp-grupp2
   ```

   Välj sen branch opponering

2. Skapa en `.env`-fil i projektroten och lägg till din MongoDB URI:

   ```
   SPRING_DATA_MONGODB_URI=mongodb+srv://<user>:<password>@<cluster-url>/<dbname>?retryWrites=true&w=majority
   ```

3. Starta applikationen:

   ```sh
   mvn spring-boot:run
   ```

### API Endpoints

#### Projekt

- `GET /api/projects/activeProjects` – Hämta alla aktiva projekt
- `GET /api/projects/finishedProjects` – Hämta alla avslutade projekt
- `POST /api/projects/newProject` – Skapa nytt projekt

#### Medlemmar

- `GET /api/members/getAllMembers` – Hämta alla medlemmar
- `GET /api/members/getMembersByProjectId/{projectId}` – Hämta medlemmar för ett projekt

#### Issues

- `POST /api/issues/newIssue/{projectId}` – Skapa nytt issue för projekt
- `GET /api/issues/inactiveIssues` – Hämta inaktiva issues
- `GET /api/issues/activeIssues` – Hämta aktiva issues
- `GET /api/issues/finishedIssues` – Hämta klara issues
- `GET /api/issues/activeIssues/{projectId}` - Hämtar aktiva issues för ett projekt
- `GET /api/issues/inactiveIssues/{projectId}` - Hämtar inaktiva issues för ett projekt
- `GET /api/issues/finishedIssues/{projectId}`- Hämtar färdiga issues för ett projekt

  ### Tidsestimering & Bokföring

- `PATCH /api/estTime/updateEstTime/{issueId}` – Uppdatera uppskattad tid för ett issue
- `PATCH /api/estTime/actualTime/{issueId}` – Uppdatera faktisk tid för ett issue


## Miljövariabler

Applikationen använder [java-dotenv](https://github.com/cdimascio/java-dotenv) för att läsa miljövariabler från `.env`-filen. Se till att ange `SPRING_DATA_MONGODB_URI` korrekt.

## Kontakt

Vid frågor, kontakta projektgruppen.

---

_Detta projekt är utvecklat som en del av en inlämningsuppgift._
