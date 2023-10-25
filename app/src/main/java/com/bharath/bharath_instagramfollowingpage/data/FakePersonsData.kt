package com.bharath.bharath_instagramfollowingpage.data

import android.util.Log
import com.bharath.bharath_instagramfollowingpage.data.database.HighLightsData


class FakePersonsData {


    fun generateFakeDataFollowRequests(): List<FollowingRequests> {

        val arrayList = ArrayList<FollowingRequests>()
        val firstNamesNew = arrayOf(
            "Alex",
            "Barbara",
            "Cameron",
            "Daniel",
            "Ella",
            "Felix",
            "Grace",
            "Henry",
            "Isabelle",
            "Jacob",
            "Katherine",
            "Lucas",
            "Megan",
            "Nathan",
            "Olivia",
            "Patrick",
            "Quinn",
            "Rebecca",
            "Samuel",
            "Tara",
            "Uma",
            "Vincent",
            "Wendy",
            "Xander",
            "Yvonne",
            "Zara"
        )

        val lastNamesNew = arrayOf(
            "Thomas",
            "Anderson",
            "Brown",
            "Lee",
            "Garcia",
            "Davis",
            "Miller",
            "Martinez",
            "Clark",
            "Lopez",
            "Hall",
            "Young",
            "Harris",
            "King",
            "Wright",
            "White",
            "Turner",
            "Cooper",
            "Stewart",
            "Hill",
            "Walker",
            "Harrison",
            "Allen",
            "Parker",
            "Baker",
            "Kennedy",
            "Carter",
            "Moore",
            "Taylor",
            "Reed",
            "Cook",
            "Murphy",
            "Evans",
            "Ross",
            "Johnson",
            "Morris",
            "Ward",
            "Fisher",
            "Peterson",
            "Bell",
            "Bailey",
            "Scott",
            "Roberts",
            "Henderson",
            "Sanders",
            "James",
            "Dixon"
        )

        val usernamesWithoutInstagramNew = listOf(
            "elife",
            "epics",
            "eloveit",
            "espirit",
            "enerd",
            "emaster",
            "elearning",
            "epro",
            "egenius",
            "emind",
            "einspire",
            "eadventure",
            "echef",
            "esocial",
            "eexplorer",
            "eoutdoors",
            "estyle",
            "eartistic",
            "edeveloper",
            "eathlete",
            "emusician",
            "edesigner",
            "etechie",
            "egamer",
            "emoviebuff",
            "eadventurer",
            "ephotographer",
            "eentrepreneur",
            "eartist",
            "etraveler",
            "edigital",
            "eeditor",
            "edirector",
            "eprofessional"
        )

        val imagesList = listOf(
            "https://randomuser.me/api/portraits/women/94.jpg",
            "https://randomuser.me/api/portraits/women/52.jpg",
            "https://randomuser.me/api/portraits/women/50.jpg",
            "https://randomuser.me/api/portraits/women/63.jpg",
            "https://randomuser.me/api/portraits/women/19.jpg",
            "https://randomuser.me/api/portraits/women/84.jpg",
            "https://randomuser.me/api/portraits/women/99.jpg",
            "https://randomuser.me/api/portraits/women/61.jpg",
            "https://randomuser.me/api/portraits/women/17.jpg",
            "https://randomuser.me/api/portraits/women/79.jpg",
            "https://randomuser.me/api/portraits/women/97.jpg",
            "https://randomuser.me/api/portraits/women/14.jpg",
            "https://randomuser.me/api/portraits/women/35.jpg",
            "https://randomuser.me/api/portraits/women/24.jpg",
            "https://randomuser.me/api/portraits/women/21.jpg",
            "https://randomuser.me/api/portraits/women/2.jpg",
            "https://randomuser.me/api/portraits/women/3.jpg",
            "https://randomuser.me/api/portraits/women/4.jpg",
            "https://randomuser.me/api/portraits/women/5.jpg",
            "https://randomuser.me/api/portraits/women/64.jpg",
            "https://randomuser.me/api/portraits/women/29.jpg",
            "https://randomuser.me/api/portraits/women/9.jpg",
            "https://randomuser.me/api/portraits/women/22.jpg",
            "https://randomuser.me/api/portraits/women/72.jpg",
            "https://randomuser.me/api/portraits/women/18.jpg",
            "https://randomuser.me/api/portraits/women/44.jpg",
            "https://randomuser.me/api/portraits/men/66.jpg",
            "https://randomuser.me/api/portraits/men/47.jpg",
            "https://randomuser.me/api/portraits/men/69.jpg",
            "https://randomuser.me/api/portraits/men/15.jpg",
            "https://randomuser.me/api/portraits/men/16.jpg",
            "https://randomuser.me/api/portraits/men/96.jpg",
            "https://randomuser.me/api/portraits/men/21.jpg",
            "https://randomuser.me/api/portraits/men/22.jpg",
            "https://randomuser.me/api/portraits/men/23.jpg",
            "https://randomuser.me/api/portraits/men/24.jpg",
            "https://randomuser.me/api/portraits/men/25.jpg",
            "https://randomuser.me/api/portraits/men/26.jpg",
            "https://randomuser.me/api/portraits/men/30.jpg",
            "https://randomuser.me/api/portraits/men/31.jpg",
            "https://randomuser.me/api/portraits/men/32.jpg",
            "https://randomuser.me/api/portraits/men/33.jpg",
            "https://randomuser.me/api/portraits/men/34.jpg"
        )

        for (i in 0..25) {
            arrayList.add(
                FollowingRequests(
                    id = i,
                    personName = firstNamesNew[i] + lastNamesNew[i],
                    personImage = imagesList[i],
                    userName = firstNamesNew[i] + usernamesWithoutInstagramNew[i]
                )
            )
        }
        return arrayList

    }

    fun generateFakeDataSuggestions(): List<PersonData> {

        val arrayList = ArrayList<PersonData>()
        val firstNames = arrayOf(
            "Alice",
            "Bob",
            "Charlie",
            "David",
            "Eva",
            "Frank",
            "Grace",
            "Hank",
            "Ivy",
            "Jack",
            "Kate",
            "Liam",
            "Mia",
            "Noah",
            "Olivia",
            "Peter",
            "Quinn",
            "Rachel",
            "Sam",
            "Tina",
            "Ulysses",
            "Vera",
            "William",
            "Xander",
            "Yara",
            "Zane",
            "Ava",
            "Ben",
            "Chloe",
            "Daniel",
            "Emily",
            "Finn",
            "Gemma",
            "Harry",
            "Isabel",
            "Jacob",
            "Lily",
            "Mason",
            "Nora",
            "Oscar",
            "Penelope",
            "Quincy",
            "Riley",
            "Sofia",
            "Thomas",
            "Uma",
            "Victor",
            "Willa",
            "Xavier",
            "Yasmin",
            "Zachary"
        )

        val lastNames = arrayOf(
            "Smith",
            "Johnson",
            "Brown",
            "Lee",
            "Garcia",
            "Davis",
            "Miller",
            "Martinez",
            "Clark",
            "Lopez",
            "Hall",
            "Young",
            "Harris",
            "King",
            "Wright",
            "White",
            "Turner",
            "Cooper",
            "Stewart",
            "Hill",
            "Anderson",
            "Allen",
            "Parker",
            "Adams",
            "Harrison",
            "Kennedy",
            "Carter",
            "Harrison",
            "Moore",
            "Taylor",
            "Reed",
            "Cook",
            "Murphy",
            "Baker",
            "Evans",
            "Ross",
            "Johnson",
            "Morris",
            "Ward",
            "Fisher",
            "Walker",
            "Peterson",
            "Bell",
            "Bailey",
            "Scott",
            "Roberts",
            "Henderson",
            "Sanders",
            "Jameson",
            "Dixon",
            "Thomas"
        )
        val usernamesWithoutInstagram = listOf(
            "er",
            "ers",
            "erlife",
            "elove",
            "ergirl",
            "erboy",
            "erswag",
            "efamous",
            "eselfie",
            "efollow",
            "ephoto",
            "evideo",
            "eexplore",
            "efood",
            "etravel",
            "enature",
            "ebeauty",
            "efashion",
            "efitness",
            "eart",
            "edesign",
            "etech",
            "esports",
            "emusic",
            "efunny",
            "emes",
            "eanimals",
            "eusa",
            "emoods",
            "evibes",
            "epicoftheday",
            "efollowforfollow",
            "emodern",
            "einflourance",
            "ephotography",
            "ebusiness",
            "emarketing",
            "eblogger",
            "einfluencer",
            "ephotoeditor",
            "ephotoshop",
            "ereels",
            "elive",
            "estories"
        )

        val listImages = listOf(
            "https://randomuser.me/api/portraits/women/44.jpg",
            "https://randomuser.me/api/portraits/women/12.jpg",
            "https://randomuser.me/api/portraits/women/40.jpg",
            "https://randomuser.me/api/portraits/women/13.jpg",
            "https://randomuser.me/api/portraits/women/9.jpg",
            "https://randomuser.me/api/portraits/women/4.jpg",
            "https://randomuser.me/api/portraits/women/64.jpg",
            "https://randomuser.me/api/portraits/women/41.jpg",
            "https://randomuser.me/api/portraits/women/87.jpg",
            "https://randomuser.me/api/portraits/women/69.jpg",
            "https://randomuser.me/api/portraits/women/87.jpg",
            "https://randomuser.me/api/portraits/women/44.jpg",
            "https://randomuser.me/api/portraits/women/55.jpg",
            "https://randomuser.me/api/portraits/women/54.jpg",
            "https://randomuser.me/api/portraits/women/1.jpg",
            "https://randomuser.me/api/portraits/women/2.jpg",
            "https://randomuser.me/api/portraits/women/3.jpg",
            "https://randomuser.me/api/portraits/women/4.jpg",
            "https://randomuser.me/api/portraits/women/5.jpg",
            "https://randomuser.me/api/portraits/women/64.jpg",
            "https://randomuser.me/api/portraits/women/74.jpg",
            "https://randomuser.me/api/portraits/women/9.jpg",
            "https://randomuser.me/api/portraits/women/32.jpg",
            "https://randomuser.me/api/portraits/women/29.jpg",
            "https://randomuser.me/api/portraits/women/28.jpg",
            "https://randomuser.me/api/portraits/women/24.jpg",
            "https://randomuser.me/api/portraits/men/46.jpg",
            "https://randomuser.me/api/portraits/men/97.jpg",
            "https://randomuser.me/api/portraits/men/89.jpg",
            "https://randomuser.me/api/portraits/men/5.jpg",
            "https://randomuser.me/api/portraits/men/45.jpg",
            "https://randomuser.me/api/portraits/men/36.jpg",
            "https://randomuser.me/api/portraits/men/21.jpg",
            "https://randomuser.me/api/portraits/men/22.jpg",
            "https://randomuser.me/api/portraits/men/23.jpg",
            "https://randomuser.me/api/portraits/men/24.jpg",
            "https://randomuser.me/api/portraits/men/25.jpg",
            "https://randomuser.me/api/portraits/men/26.jpg",
            "https://randomuser.me/api/portraits/men/30.jpg",
            "https://randomuser.me/api/portraits/men/31.jpg",
            "https://randomuser.me/api/portraits/men/32.jpg",
            "https://randomuser.me/api/portraits/men/33.jpg",
            "https://randomuser.me/api/portraits/men/34.jpg",

            )
        Log.d("FakeData", "generateFakeData: " + listImages.size)

        for (i in listImages.indices) {
            arrayList.add(
                PersonData(
                    id = i,
                    personName = firstNames[i] + " " + lastNames[i],
                    userName = firstNames[i] + usernamesWithoutInstagram[i],
                    isFollowing = false,
                    personImage = listImages[i]
                )
            )
        }


        return arrayList;
    }

    fun generateFakeHighlights(): List<HighLightsData> {

        val imageList = listOf(
            HighLightsData(
                id = 1,
                image = "https://images.pexels.com/photos/147411/italy-mountains-dawn-daybreak-147411.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "🗻Mountain"
            ), HighLightsData(
                id = 2,
                image = "https://images.pexels.com/photos/1366919/pexels-photo-1366919.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "🏞️Nature"
            ), HighLightsData(
                id = 3,
                image = "https://images.pexels.com/photos/1743165/pexels-photo-1743165.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "❤️😍"
            ), HighLightsData(
                id = 4,
                image = "https://images.pexels.com/photos/3692609/pexels-photo-3692609.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "Crane🕊️"
            ), HighLightsData(
                id = 5,
                image = "https://images.pexels.com/photos/18806554/pexels-photo-18806554/free-photo-of-a-group-of-people-holding-spoons-over-a-cake.jpeg?auto=compress&cs=tinysrgb&w=200&lazy=load",
                name = "Bday🎂"
            )
            ,HighLightsData(
                id = 6,
                image = "https://images.pexels.com/photos/18401184/pexels-photo-18401184/free-photo-of-a-man-standing-head-to-head-with-a-horse.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "Love🏇🏻"
            ),HighLightsData(
                id = 7,
                image = "https://images.pexels.com/photos/18570210/pexels-photo-18570210/free-photo-of-men-on-horses-at-farm.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "Jockey"
            )
            ,HighLightsData(
                id = 8,
                image = "https://images.pexels.com/photos/17774928/pexels-photo-17774928/free-photo-of-laptop-and-water-with-lemon.jpeg?auto=compress&cs=tinysrgb&w=300&h=210&dpr=1",
                name = "Work"
            ),HighLightsData(
                id = 9,
                image = "https://images.pexels.com/photos/10718781/pexels-photo-10718781.jpeg?auto=compress&cs=tinysrgb&w=300&h=215&dpr=1",
                name = "Asian   "
            )


        )



        return imageList
    }


}