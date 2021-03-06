package FinalProject;
import java.io.*;
import java.util.*;

public class FinalProject{
    public static ArrayList armor = new ArrayList();
    public static ArrayList inventory = new ArrayList();
    public static ArrayList shields = new ArrayList();
    public static ArrayList weapons = new ArrayList();
    public static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    public static int abilityPoints = 12;
    public static int player1AC = 10;
    public static int player1age = 0;
    public static int player1agility = 10;
    public static int player1agilitymodifier = 0;
    public static int player1agilitytotal = 0;
    public static int player1attackroll = 0;
    public static int player1endurance = 10;
    public static int player1endurancemodifier = 0;
    public static int player1endurancetotal = 0;
    public static int player1exptotal = 0;
    public static int player1level = 1;
    public static int player1maxHP = 0;
    public static int player1money = 1000;
    public static int player1racialagility = 0;
    public static int player1racialagilitymod = 0;
    public static int player1racialendurance = 0;
    public static int player1racialendurancemod = 0;
    public static int player1racialstr = 0;
    public static int player1racialstrmod = 0;
    public static int player1strength = 10;
    public static int player1strmodifier = 0;
    public static int player1strtotal = 0;
    public static int player1totalAC = 0;
    public static int player1totalagilitymod = 0;
    public static int player1totalendurancemod = 0;
    public static int player1totalHP = 0;
    public static int player1totalstrmod = 0;
    public static int skeleton1AC = 14;
    public static int skeleton1agility = 10;
    public static int skeleton1agilitymod = 0;
    public static int skeleton1attackroll = 0;
    public static int skeleton1endurance = 14;
    public static int skeleton1endurancemod = 2;
    public static int skeleton1HP = 19;
    public static int skeleton1str = 14;
    public static int skeleton1strmod = 2;
    public static int zombie1AC = 15;
    public static int zombie1agility = 6;
    public static int zombie1agilitymod = -2;
    public static int zombie1attackroll = 0;
    public static int zombie1endurance = 14;
    public static int zombie1endurancemod = 2;
    public static int zombie1HP = 27;
    public static int zombie1str = 16;
    public static int zombie1strmod = 3;
    public static Random numbermaker = new Random();
    public static String currentArmor = "rags";
    public static String currentShield = "none";
    public static String currentWeapon = "fists";
    public static String player1 = "";
    public static String player1race = "";

    public static void main(String args[]) throws IOException, InterruptedException{
        welcome();
        System.out.println("\nFirst, what is your name?");
        player1 = keyboard.readLine();
        Thread.sleep(1500);
        System.out.println("Welcome " + player1);
        Thread.sleep(750);
        System.out.println("\nAge?");
        String input2 = keyboard.readLine();
        player1age = Integer.parseInt(input2);
        if(player1age <= 8){
            System.out.println("Aren't you a little young for this game?\nAnyway...");

        }else if(player1age >= 30){
            System.out.println("Why is such an old coot like you playing this game???\nAnyway...");
        }
        Thread.sleep(2000);
        System.out.println("Choose your race. Options:\nHuman\nElf\nDwarf\n");
        while(1 == 1){
            player1race = keyboard.readLine();
            if(player1race.equals("human")){
                System.out.println("\nYou chose Human. You gain no racial modifiers to your abilities.");
                break;

            }else if(player1race.equals("elf")){
                System.out.println("\nYou chose Elf, you gain +4 agility but -2 strength and -2 endurance.");
                player1racialstr = -2;
                player1racialstrmod = -1;
                player1racialagility = 4;
                player1racialagilitymod = 2;
                player1racialendurance = -2;
                player1racialendurancemod = -1;
                break;

            }else if(player1race.equals("dwarf")){
                System.out.println("\nYou chose Dwarf, you gain +2 strength and +2 endurance, but -4 agility.");
                player1racialstr = 2;
                player1racialstrmod = 1;
                player1racialagility = -4;
                player1racialagilitymod = -2;
                player1racialendurance = 2;
                player1racialendurancemod = 1;
                break;

            }else{
                System.out.println("\nYou must choose Human, Elf, or Dwarf.\n");
            }
        }
        abilities();
    }

    public static void welcome() throws IOException, InterruptedException{
        System.out.println("Welcome to Dungeon Explorer!");
        Thread.sleep(1500);
        System.out.println("In this text adventure, you must design a character and equip him with items.");
        Thread.sleep(1500);
        System.out.println("After you finish the preperations, you can explore the nearby Dungeon!");
        Thread.sleep(1500);
        System.out.println("But beware! The Dungeon is full of enemies!");
        Thread.sleep(1500);
        System.out.println("Loading...");
        for(int i = 0; i < 80; i++){
            System.out.print("_");
            Thread.sleep(25);
        }
        System.out.println();
    }

    public static void oakhurst() throws IOException, InterruptedException{
        System.out.println("\nLoading...");
        for(int i = 0; i < 80; i++){
            System.out.print("_");
            Thread.sleep(25);
        }
        while(1 == 1){
            System.out.println("\nWelcome to the town of Oakhurst " + player1 + ".\nYou may now buy items.\n");
            System.out.println("Where would you like to shop? The current buildings are:\nGeneral Store\nMagic Shop\nWeapon and Armor Shop\nInn\n");
            System.out.println("Or type items and hit enter to see a discription of all available items.");
            System.out.println("Type stats and hit enter to see your current stats.");
            System.out.println("When you are done shopping, you may go to the \"dungeon\" or the \"forest\".\n");
            String player1shop = keyboard.readLine();
            if(player1shop.indexOf("general") >= 0){
                generalStore();

            }else if(player1shop.indexOf("magic") >= 0){
                magicShop();

            }else if(player1shop.indexOf("weapon") >= 0 || player1shop.indexOf("armor") >= 0){
                weaponArmorShop();

            }else if(player1shop.indexOf("inn") >= 0){
                inn();

            }else if(player1shop.indexOf("items") >= 0){
                items();

            }else if(player1shop.indexOf("inventory") >= 0){
                inventory();

            }else if(player1shop.indexOf("stats") >= 0){
                statPage();

            }else if(player1shop.indexOf("forest") >= 0){
                forest();
                break;

            }else if(player1shop.IndexOf("dungeon") >= 0){
                dungeon();
                break;
            }
        }
    }

    public static void generalStore() throws IOException, InterruptedException{
        Thread.sleep(1500);
        System.out.println("\n\nYou have entered the general store.");
        while(1 == 1){
            System.out.println("You have " + player1money + " gold to spend.\n");
            System.out.println("In this store you can buy:\n1.Backpack           cost 2gold (a backpack is required to carry other items.)\n2.Torches            cost 1gold for three\n3.Flint and Steel    cost 2gold\n");
            System.out.println("(Type items and hit enter to see item descriptions)");
            System.out.println("\nWhat would you like to buy? (type the number of the item to buy it\nand type done when done buying all your items)");
            String player1generalbuy = keyboard.readLine();
            if(player1generalbuy.indexOf("items") >= 0){
                items();

            }else if(player1generalbuy.indexOf("magic") >= 0){
                magicShop();

            }else if(player1generalbuy.indexOf("weapon") >= 0 || player1generalbuy.indexOf("armor") >= 0){
                weaponArmorShop();

            }else if(player1generalbuy.indexOf("inn") >= 0){
                inn();

            }else if(player1generalbuy.indexOf("stats") >= 0){
                statPage();

            }else if(player1generalbuy.indexOf("oakhurst") >= 0){
                oakhurst();

            }else if(player1generalbuy.indexOf("done") >= 0){
                break;
            }
        }
    }

    public static void magicShop() throws IOException, InterruptedException{
        Thread.sleep(1500);
        System.out.println("\n\nYou have entered the magic shop.");
        while(1 == 1){
            System.out.println("You have " + player1money + " gold to spend.\n");
            System.out.println("In this store you can buy:\n1.Magic Sword           cost 500gold\n2.Magic Axe             cost 500gold\n3.Magic Dagger          cost 300gold\n4.Magic Plate Mail      cost 750gold\n5.Magic Bow             cost 550gold\n6.Magic Leather Armor   cost 250gold\n7.Magic Shield          cost 200(small) 300(large)");
            System.out.println("(Type items and hit enter to see item descriptions)");
            System.out.println("\nWhat would you like to buy? (type the number of the item to buy it\nand type done when done buying all your items)");
            String player1magicbuy = keyboard.readLine();
            if(player1magicbuy.indexOf("items") >= 0){
                items();

            }else if(player1magicbuy.indexOf("general") >= 0){
                generalStore();

            }else if(player1magicbuy.indexOf("weapon") >= 0 || player1magicbuy.IndexOf("armor") >= 0){
                weaponArmorShop();

            }else if(player1magicbuy.indexOf("inn") >= 0){
                inn();

            }else if(player1magicbuy.indexOf("stats") >= 0){
                statPage();

            }else if(player1magicbuy.indexOf("oakhurst") >= 0){
                oakhurst();

            }else if(player1magicbuy.indexOf("done") >= 0){
                break;
            }
        }
    }

    public static void weaponArmorShop() throws IOException, InterruptedException{
        Thread.sleep(1500);
        System.out.println("\n\nYou have entered the weapon and armor shop.");
        while(1 == 1){
            System.out.println("You have " + player1money + " gold to spend.\n");
            System.out.println("In this store you can buy:\n1.Leather Armor          cost 100gold\n2.Plate Mail             cost 300gold\n3.Small Shield           cost 50gold\n4.Large Shield           cost 100gold\n5.Bow                    cost 100gold\n6.Sword                  cost 100gold\n7.Dagger                 cost 50gold\n8.Axe                    cost 125gold\n");
            System.out.println("(Type items and hit enter to see item descriptions)");
            System.out.println("\nWhat would you like to buy? (type the number of the item to buy it\nand type done when done buying all your items)");
            String player1weaparmorbuy = keyboard.readLine();
            if(player1weaparmorbuy.indexOf("items") >= 0){
                items();

            }else if(player1weaparmorbuy.indexOf("1") >= 0){
                player1money = player1money - 100;
                armor.add("Leather Armor");
                System.out.println("You bought Leather Armor.");

            }else if(player1weaparmorbuy.indexOf("2") >= 0){
                player1money = player1money - 300;
                armor.add("Plate Mail");
                System.out.println("You bought Plate Mail.");

            }else if(player1weaparmorbuy.indexOf("3") >= 0){
                player1money = player1money - 50;
                shields.add("Small Shield");
                System.out.println("You bought a Small Shield.");

            }else if(player1weaparmorbuy.indexOf("4") >= 0){
                player1money = player1money - 100;
                shields.add("Large Shield");
                System.out.println("You bought a Large Shield.");

            }else if(player1weaparmorbuy.indexOf("5") >= 0){
                player1money = player1money - 100;
                weapons.add("Bow");
                System.out.println("You bought a Bow.");

            }else if(player1weaparmorbuy.indexOf("6") >= 0){
                player1money = player1money - 100;
                weapons.add("Sword");
                System.out.println("You bought a Sword.");

            }else if(player1weaparmorbuy.indexOf("7") >= 0){
                player1money = player1money - 50;
                weapons.add("Dagger");
                System.out.println("You bought a Dagger.");

            }else if(player1weaparmorbuy.indexOf("8") >= 0){
                player1money = player1money - 125;
                weapons.add("Axe");
                System.out.println("You bought an Axe.");

            }else if(player1weaparmorbuy.indexOf("magic") >= 0){
                magicShop();

            }else if(player1weaparmorbuy.indexOf("general") >= 0){
                generalStore();

            }else if(player1weaparmorbuy.indexOf("inn") >= 0){
                inn();

            }else if(player1weaparmorbuy.indexOf("stats") >= 0){
                statPage();

            }else if(player1weaparmorbuy.indexOf("oakhurst") >= 0){
                oakhurst();

            }else if(player1weaparmorbuy.indexOf("done") >= 0){
                break;
            }
        }
    }

    public static void inn() throws IOException, InterruptedException{
        Thread.sleep(1500);
        System.out.println("\n\nYou have entered the inn.");
        while(1 == 1){
            System.out.println("You have " + player1money + " gold to spend.\n");
            System.out.println("In this store you can buy:\n1.Beer     cost 1gold\n");
            System.out.println("(Type items and hit enter to see item descriptions)");
            System.out.println("\nWhat would you like to buy? (type the number of the item to buy it\nand type done when done buying all your items)");
            String player1innbuy = keyboard.readLine();
            if(player1innbuy.indexOf("items") >= 0){
                items();

            }else if(player1innbuy.indexOf("magic") >= 0){
                magicShop();

            }else if(player1innbuy.indexOf("weapon") >= 0 || player1innbuy.indexOf("armor") >= 0){
                weaponArmorShop();

            }else if(player1innbuy.indexOf("general") >= 0){
                generalStore();

            }else if(player1innbuy.indexOf("stats") >= 0){
                statPage();

            }else if(player1innbuy.indexOf("rest") >= 0){
                player1totalHP = player1maxHP;

            }else if(player1innbuy.indexOf("oakhurst") >= 0){
                oakhurst();

            }else if(player1innbuy.indexOf("done") >= 0){
                break;
            }
        }
    }

    public static void statPage() throws IOException, InterruptedException{
        System.out.println("\t\t\t       STATS");
        System.out.println("\t\tName: " + player1);
        System.out.println("\t\tAge: " + player1age);
        System.out.println("\t\tRace: " + player1race);
        System.out.println("\t\tLevel: " + player1level);
        System.out.println("\t\tExp: " + player1exptotal);
        System.out.println("\t\tStrength:  " + player1strtotal + "  Modifier: + " + player1totalstrmod);
        System.out.println("\t\tAgility:   " + player1agilitytotal + "  Modifier: + " + player1totalagilitymod);
        System.out.println("\t\tEndurance: " + player1endurancetotal + "  Modifier: + " + player1totalendurancemod);
        System.out.println("\t\tHP: " + player1totalHP + "/" + player1maxHP);
        System.out.println("\t\tAC: " + player1totalAC);
        System.out.println("\t\tCurrent Weapon: " + currentWeapon);
        System.out.println("\t\tCurrent Armor: " + currentArmor);
        System.out.println("\t\tCurrent Shield: " + currentShield);
        System.out.println("\t\tCurrent Gold: " + player1money);
        System.out.println("\t\tMelee Attack Bonus: + " + player1totalstrmod);
        System.out.println("\t\tRanged Attack Bonus: + " + player1totalagilitymod);
        System.out.println("\n\nType done when your are done to exit the stat page.");
        while(1 == 1){
            String player1stats = keyboard.readLine();
            if(player1stats.indexOf("items") >= 0){
                items();

            }else if(player1stats.indexOf("magic") >= 0){
                magicShop();

            }else if(player1stats.indexOf("weapon") >= 0 ||  player1stats.indexOf("armor") >= 0){
                weaponArmorShop();

            }else if(player1stats.indexOf("inn") >= 0){
                inn();

            }else if(player1stats.indexOf("stats") >= 0){
                statPage();

            }else if(player1stats.indexOf("general") >= 0){
                generalStore();

            }else if(player1stats.indexOf("oakhurst") >= 0){
                oakhurst();

            }else if(player1stats.indexOf("done") >= 0){
                break;

            }else{
                System.out.println("I can't do that. Type done to leave");
            }
        }
    }

    public static void inventory() throws IOException, InterruptedException{
        Thread.sleep(1500);
        System.out.println("\n\nItems:\n");
        for(int index = 0; index < inventory.size(); index++){
            System.out.println(inventory.get(index));
        }
        Thread.sleep(1500);
        System.out.println("\nShields:\n");
        for(int index = 0; index < shields.size(); index++){
            System.out.println(shields.get(index));
        }
        Thread.sleep(1500);
        System.out.println("\n\nArmor:\n");
        for(int index = 0; index < armor.size(); index++){
            System.out.println(armor.get(index));
        }
        Thread.sleep(1500);
        System.out.println("\n\nWeapons:\n");
        for(int index = 0; index < weapons.size(); index++){
            System.out.println(weapons.get(index));
        }
        Thread.sleep(750);

        while(1 == 1){
            System.out.println("Type the name of an item to equip it");
            String equip = keyboard.readLine();
            equip = equip.toLowerCase();

            if(equip.equals("done")){
                break;
            }

            for(int index = 0; index < inventory.size(); index++){
                String item = inventory.get(index).toString();
                if(equip.equals(item.toLowerCase())){
                    break;
                }
            }
            for(int index = 0; index < armor.size(); index++){
                String item = armor.get(index).toString();
                if(equip.equals(item.toLowerCase())){
                    currentArmor = item;
                    break;
                }
            }
            for(int index = 0; index < weapons.size(); index++){
                String item = weapons.get(index).toString();
                if(equip.equals(item.toLowerCase())){
                    currentWeapon = item;
                    break;
                }
            }
            for(int index = 0; index < shields.size(); index++){
                String item = shields.get(index).toString();
                if(equip.equals(item.toLowerCase())){
                    currentShield = item;
                    break;
                }
            }
        }
    }

    public static void items() throws IOException, InterruptedException{
        System.out.println("\t\t\t  ITEM DESCRIPTIONS");
        System.out.println("Torches: Torches are used to light up dark areas. When lit with flint and steel\nyou ignore the chance of getting lost.");
        System.out.println("Flint and Steel: Used to light torches.");
        System.out.println("Trail Rations: Each day you must consume 1days worth of trail rations or you \nwill die.");
        System.out.println("Magic weapons/armor: Any weapon with \"magic\" before its name, adds 1 to your\n attack and damage rolls. Magic armor and shields add 1 to the AC bonus.");
        System.out.println("Non Magic weapons/armor: Any weapon or armor without \"magic\" in front of it\nis just a normal weapon or armor.");
        System.out.println("Beer: Raises your strength by 2 but lowers your agility by 2. Lasts a few rounds.\n");
        System.out.println("(Press the name of any store to go back)");
        while(1 == 1){
            String player1itembuy = keyboard.readLine();
            if(player1itembuy.indexOf("magic shop") >= 0){
                magicShop();

            }else if(player1itembuy.indexOf("weapon and armor shop") >= 0){
                weaponArmorShop();

            }else if(player1itembuy.indexOf("general store") >= 0){
                generalStore();

            }else if(player1itembuy.indexOf("inn") >= 0){
                inn();

            }else if(player1itembuy.IndexOf("stats") >= 0){
                statPage();

            }else if(player1itembuy.indexOf("oakhurst") >= 0){
                break;

            }else if(player1itembuy.indexOf("done") >= 0){
                break;

            }else{
                System.out.println("I can't do that. Type done to leave.");
            }
        }
    }

    public static void forest() throws IOException, InterruptedException{
        System.out.println("Loading...");
        for(int i = 0; i < 80; i++){
            System.out.print("_");
            Thread.sleep(25);
        }
        System.out.println("You enter the forest");
        while(1 == 1){
            System.out.println("What do you want to do? Go forward or back to town?");
            String player1forestchoice = keyboard.readLine();
            if(player1forestchoice.indexOf("forward") >= 0){
                System.out.println("\nYou get lost. GAME OVER\n");
                break;

            }else if(player1forestchoice.indexOf("oakhurst") >= 0 || player1forestchoice.indexOf("town") >= 0){
                System.out.println("You leave the forest.\n");
                oakhurst();

            }else{
                System.out.println("I can't do that.");
            }
        }
    }

    public static void dungeon () throws IOException, InterruptedException{
        System.out.println("Loading...");
        for(int i = 0;i < 80; i++){
            System.out.print("_");
            Thread.sleep(25);
        }
        System.out.println("\nYou have entered the dungeon and encountered a intersection.");
        while(1 == 1){
            System.out.println("What would you like to do now? Left, right or back?");
            String player1dungeonchoice = keyboard.readLine();
            if(player1dungeonchoice.indexOf("left") >= 0){
                if(skeleton1HP > 0){
                    System.out.println("\nYou encounter a skeleton.\nWhat do you do? Run away or fight?");
                    String skeleton1choice = keyboard.readLine();
                    if(skeleton1choice.indexOf("fight") >= 0){
                        skeleton1Fight();

                    }else if(skeleton1choice.indexOf("run") >= 0){
                        skeleton1Retreat();

                    }else{
                        System.out.println("I can't do that.");
                    }

                }else{
                    System.out.println("The room is empty.");
                }

            }else if(player1dungeonchoice.indexOf("right") >= 0){
                System.out.println("\nYou encounter a zombie.\nWhat do you do? Run away or fight?");
                String zombie1choice = keyboard.readLine();
                if(zombie1choice.indexOf("fight") >= 0){
                    zombie1Fight();

                }else if(zombie1choice.indexOf("run") >= 0){
                    zombie1Retreat();

                }else{
                    System.out.println("I can't do that.");
                }

            }else if(player1dungeonchoice.indexOf("back") >= 0 || player1dungeonchoice.indexOf("town") >= 0){
                System.out.println("You leave the dungeon.\n");
                oakhurst();

            }else{
                System.out.println("\nI can't do that.\n");
            }
        }
    }

    public static void zombie1Retreat() throws IOException, InterruptedException{
        while(1 == 1){
            System.out.println("\nYou go back through the passage.");
            System.out.println("You can now go out of the dungeon, forward, or back to where you saw the zombie.");
            System.out.println("Where do you want to go?");
            String zombie1retreat = keyboard.readLine();
            if(zombie1retreat.indexOf("out") >= 0){
                System.out.println("\nYou leave the dungeon.\n");
                oakhurst();

            }else if(zombie1retreat.indexOf("forward") >= 0){
                skeleton1Fight();

            }else if(zombie1retreat.indexOf("back") >= 0){
                if(zombie1HP > 0){
                    System.out.println("\nYou encounter the zombie.\nWhat do you do? Run away or fight?");
                    String zombie1choice = keyboard.readLine();
                    if(zombie1choice.indexOf("fight") >= 0){
                        zombie1Fight();

                    }else if(zombie1choice.indexOf("run") >= 0){
                        zombie1Retreat();
                    }

                }else{
                    System.out.println("The room is empty the zombie is dead.");
                }
            }
        }
    }

    public static void abilities() throws IOException, InterruptedException{
        Thread.sleep(1500);
        System.out.println("You must now choose your Strength, Agility, and Endurance. Each start at 10 and you have " + abilityPoints + " points to use.");
        Thread.sleep(1500);
        System.out.println("\nFirst choose your Strength.\nYour strength modifier is the bonus to the damage dealt by your melee and \ncertain ranged weapons and attack rolls with melee weapons.\nPick a number between 10 and 18. \n(remember, you have " + abilityPoints + " total points to use in all three abilities.)\n");
        while(abilityPoints > 0){
            String input = keyboard.readLine();
            player1strength = Integer.parseInt(input);
            if(player1strength >= 10 && player1strength <= 18){
                if(player1strength > abilityPoints + 10){
                    player1strength = abilityPoints + 10;
                }
                abilityPoints = abilityPoints - (player1strength - 10);
                System.out.println("You have " + abilityPoints + " ability points left");
                break;

            }else{
                System.out.println("You must pick a number between 10 and 18");
            }
        }
        player1strtotal = player1strength + player1racialstr;
        System.out.println("\n\nYour strength is " + player1strength + " + " + player1racialstr + " for being a " + player1race + " for a total of " + player1strtotal);
        if(player1strength > 11 && player1strength < 14){
            player1strmodifier = player1strmodifier + 1;

        }else if(player1strength < 16){
            player1strmodifier = player1strmodifier + 2;

        }else if(player1strength < 18){
            player1strmodifier = player1strmodifier + 3;

        }else{
            player1strmodifier = player1strmodifier + 4;
        }
        player1totalstrmod = player1strmodifier + player1racialstrmod;
        System.out.println("Your strength modifier is " + player1strmodifier + " + " + player1racialstrmod + " for being a " + player1race + " for a total of +" + player1totalstrmod + "\n\n");
        Thread.sleep(1500);
        System.out.println("\nNow choose your agility.\nYour agility modifier is the bonus to your AC. The higher you AC the less\nchance enemies have to hit you and a bonus on your ranged attack rolls.\nPick a number between 10 and 18. \n");
        while(abilityPoints > 0){
            String input = keyboard.readLine();
            player1agility = Integer.parseInt(input);

            if(player1agility >= 10 && player1agility <= 18){
                if(player1agility > abilityPoints + 10){
                    player1agility = abilityPoints + 10;
                }
                abilityPoints = abilityPoints - (player1agility - 10);
                System.out.println("You have " + abilityPoints + " ability points left");
                break;

            }else{
                System.out.println("You must pick a number between 10 and 18");
            }
        }
        player1agilitytotal = player1agility + player1racialagility;
        System.out.println("\n\nYour agility score is " + player1agility + " + " + player1racialagility + " for being a " + player1race + " for a total of " + player1agilitytotal);
        if(player1agility > 11 && player1agility < 14){
            player1agilitymodifier = player1agilitymodifier + 1;

        }else if(player1agility < 16){
            player1agilitymodifier = player1agilitymodifier + 2;

        }else if(player1agility < 18){
            player1agilitymodifier = player1agilitymodifier + 3;

        }else{
            player1agilitymodifier = player1agilitymodifier + 4;
        }
        player1totalagilitymod = player1agilitymodifier + player1racialagilitymod;
        System.out.println("Your agility modifier is " + player1agilitymodifier + " + " + player1racialagilitymod + " for being a " + player1race + " for a total of +" + player1totalagilitymod + "\n\n");
        player1totalAC = player1AC + player1totalagilitymod;
        Thread.sleep(1500);
        System.out.println("\nNow choose your endurance.\nYour endurance modifier is the bonus to your HP (hit points). The higher your endurance the more hp you have and the farther you can run without resting.\nPick a number between 10 and 18. \n");
        while(abilityPoints > 0){
            String input = keyboard.readLine();
            player1endurance = Integer.parseInt(input);
            if(player1endurance >= 10 && player1endurance <= 18){
                if(player1endurance > abilityPoints + 10){
                    player1endurance = abilityPoints + 10;
                }
                abilityPoints = abilityPoints - (player1endurance - 10);
                System.out.println("You have " + abilityPoints + " ability points left");
                break;

            }else{
                System.out.println("You must pick a number between 10 and 18");
            }
        }
        player1endurancetotal = player1endurance + player1racialendurance;
        System.out.println("\n\nYour endurance score is " + player1endurance + " + " + player1racialendurance + " for being a " + player1race + " for a total of " + player1endurancetotal);
        if(player1endurance > 11 && player1endurance < 14){
            player1endurancemodifier = player1endurancemodifier + 1;

        }else if(player1endurance < 16){
            player1endurancemodifier = player1endurancemodifier + 2;

        }else if(player1endurance < 18){
            player1endurancemodifier = player1endurancemodifier + 3;

        }else{
            player1endurancemodifier = player1endurancemodifier + 4;
        }
        player1totalendurancemod = player1endurancemodifier + player1racialendurancemod;
        System.out.println("Your endurance modifier is " + player1endurancemodifier + " + " + player1racialendurancemod + " for being a " + player1race + " for a total of +" + player1totalendurancemod);
        player1totalHP = numbermaker.nextInt(11) + 10;
        player1totalHP = player1totalHP + player1totalendurancemod + player1level;
        player1maxHP = player1totalHP;
        oakhurst();
    }

    public static void zombie1Fight() throws IOException, InterruptedException{
        System.out.println("\nYou decide to fight the zombie.\nYou act first.");
        while(zombie1HP > 0){
            System.out.println("What do you do? Attack or run? You can also type stats to see your stats.");
            String player1zombiefight = keyboard.readLine();
            if(player1zombiefight.indexOf("attack") >= 0){
                System.out.println("You try to hit the zombie with your weapon.");
                Thread.sleep(1500);
                player1attackroll = numbermaker.nextInt(20) + 1;
                if(player1attackroll + player1totalstrmod >= zombie1AC){
                    System.out.println("\nYou hit!");
                    int damage = 1;
                    if(numbermaker.nextDouble() > .5){
                        damage = 2;
                    }

                    Thread.sleep(1500);
                    System.out.println("You do " + damage + " + " + player1totalstrmod + " for a total of " + (player1totalstrmod + damage) + " damage.\n");
                    zombie1HP = zombie1HP - (damage + player1totalstrmod);
                    if(zombie1HP <= 0){
                        System.out.println("You destroy the zombie.\nYou gain 500 exp.");
                        player1exptotal = player1exptotal + 500;
                        if(player1exptotal >= 1000){
                            System.out.println("You gained a level!");
                            player1level = player1level + 1;
                            player1totalHP = player1totalHP + (player1totalendurancemod * player1level);
                        }
                        break;
                    }

                }else{
                    Thread.sleep(750);
                    System.out.println("\nYou miss.\n");
                }
                Thread.sleep(1500);
                System.out.println("The zombie tries to attack you with its giant fists.");
                Thread.sleep(1500);
                zombie1attackroll = numbermaker.nextInt(20) + 1;
                if(zombie1attackroll + zombie1strmod >= player1AC){
                    System.out.println("\nIt hits.");
                    int damage = 1;
                    if(numbermaker.nextDouble() > .5){
                        damage = 2;
                    }

                    Thread.sleep(1500);
                    System.out.println("The zombie does " + damage + " + " + zombie1strmod + " for a total of " + (zombie1strmod + damage) + " damage.\n");
                    player1totalHP = player1totalHP - (damage + zombie1strmod);
                    if(player1totalHP <= 0){
                        System.out.println("You died. GAME OVER.");
                        System.exit(0);
                    }

                }else{
                    Thread.sleep(750);
                    System.out.println("\nIt missed.\n");
                }

            }else if(player1zombiefight.indexOf("run") >= 0){
                zombie1Retreat();

            }else if(player1zombiefight.indexOf("stats") >= 0){
                statPage();
            }
        }
        zombie1Retreat();
    }

    public static void skeleton1Fight() throws IOException, InterruptedException{
        System.out.println("\nYou decide to fight the skeleton.\nYou act first.");
        while(skeleton1HP > 0){
            System.out.println("What do you do? Attack or run? You can also type stats to see your stats.");
            String player1skeletonfight = keyboard.readLine();
            if(player1skeletonfight.indexOf("attack") >= 0){
                System.out.println("You try to hit the skeleton with your weapon.");
                Thread.sleep(1500);
                player1attackroll = numbermaker.nextInt(20) + 1;
                if(player1attackroll + player1totalstrmod >= skeleton1AC){
                    System.out.println("\nYou hit!");
                    int damage = 1;
                    if(numbermaker.nextDouble() > .5){
                        damage = 2;
                    }

                    Thread.sleep(1500);
                    System.out.println("You do " + damage + " + " + player1totalstrmod + " for a total of " + (player1totalstrmod + damage) + " damage.\n");
                    skeleton1HP = skeleton1HP - (damage + player1totalstrmod);
                    if(skeleton1HP <= 0){
                        System.out.println("You destroy the skeleton.\nYou gain 500 exp.");
                        player1exptotal = player1exptotal + 500;
                        if(player1exptotal >= 1000){
                            System.out.println("You gained a level!");
                            player1level = player1level + 1;
                            player1totalHP = player1totalHP + (player1totalendurancemod * player1level);
                        }
                        break;
                    }

                }else{
                    Thread.sleep(750);
                    System.out.println("\nYou miss.\n");
                }
                Thread.sleep(1500);
                System.out.println("The skeleton tries to attack you with its claws.");
                Thread.sleep(1500);
                skeleton1attackroll = numbermaker.nextInt(20) + 1;
                if(skeleton1attackroll + skeleton1strmod >= player1AC){
                    System.out.println("\nIt hits.");
                    int damage = 1;
                    if(numbermaker.nextDouble() > .5){
                        damage = 2;
                    }

                    Thread.sleep(1500);
                    System.out.println("The skeleton does " + damage + " + " + skeleton1strmod + " for a total of " + (skeleton1strmod + damage) + " damage.\n");
                    player1totalHP = player1totalHP - (damage + skeleton1strmod);
                    if(player1totalHP <= 0){
                        System.out.println("You died. GAME OVER.");
                        System.exit(0);
                    }

                }else{
                    Thread.sleep(750);
                    System.out.println("\nIt missed.\n");
                }

            }else if(player1skeletonfight.indexOf("run") >= 0){
                skeleton1Retreat();

            }else if(player1skeletonfight.indexOf("stats") >= 0){
                statPage();
            }
        }
        skeleton1Retreat();
    }

    public static void skeleton1Retreat() throws IOException, InterruptedException{
        while(1 == 1){
            System.out.println("\nYou go back through the passage.");
            System.out.println("You can now go out of the dungeon, forward, or back to where you saw the\nskeleton.");
            System.out.println("Where do you want to go?");
            String skeleton1retreat = keyboard.readLine();
            if(skeleton1retreat.indexOf("out") >= 0){
                System.out.println("\nYou leave the dungeon.\n");
                oakhurst();

            }else if(skeleton1retreat.indexOf("forward") >= 0){
                if(zombie1HP <= 0){
                    System.out.println("The room is empty, the zombie is dead.");

                }else{
                    zombie1Fight();
                }

            }else if(skeleton1retreat.indexOf("back") >= 0){
                if(skeleton1HP >= 1){
                    System.out.println("\nYou encounter the skeleton.");
                    System.out.println("What do you do? Run away or fight?");
                    String skeleton1choice = keyboard.readLine();
                    if(skeleton1choice.indexOf("fight") >= 0){
                        skeleton1Fight();

                    }else if(skeleton1choice.indexOf("run") >= 0){
                        skeleton1Retreat();
                    }

                }else{
                    System.out.println("The room is empty, the skeleton is dead.");
                }
            }
        }
    }
}
