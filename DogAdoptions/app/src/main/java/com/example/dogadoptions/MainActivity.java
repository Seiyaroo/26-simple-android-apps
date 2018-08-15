package com.example.dogadoptions;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogadoptions.models.DogAdoptions;


public class MainActivity extends AppCompatActivity {
    private int currentIndex;

    //Creating an array of dogs to choose from and display.
    DogAdoptions[] dogs = {
            new DogAdoptions("Boomer", R.drawable.boomer, "\t\n" +
                    "Boomer is a sweet, sensitive love bug. He can be a bit timid at first, but with a little string cheese, and a lot of love, he will become your best buddy in no time at all. Boomer is a non-stop tail wagger who loves to cuddle and be with his people. He is easy to handle, curious, gentle and affectionate. Boomer will be an excellent companion for leisurely strolls and snuggling on the couch. All this little sweet heart is missing is YOU!"),
            new DogAdoptions("Kirby", R.drawable.kirby, "\t\n" +
                    "Look at this sweet face! Sweet Kirby wants nothing more than to cuddle with her family. She's a petite girl with a gentle nature. She was in a foster home for a while, and she loved to play with her foster brother (dog) and followed her 5-year-old foster sister (child) around the house. She would do well with dog-savvy kids and would love to have a doggy sibling who would play with her. Cats may be too tempting to chase. She would make the perfect buddy to take jogging or hiking, then curling up with on the couch for a movie."),
            new DogAdoptions("Martha", R.drawable.martha, "We're still getting to know Martha - to learn more, please visit the Seattle Animal Shelter. We're unable to answer questions by phone or email, thanks."),
            new DogAdoptions("Peaches", R.drawable.peaches, "Peaches is a lovely, gentle, senior lady seeking her forever home. She would be an ideal choice for someone considering their first dog adoption. She knows sit, is gentle, calm and easy to handle. She enjoys leisurely strolls, is a non-stop tail wagger and a loving companion."),
            new DogAdoptions("Polaris", R.drawable.polaris,"He's a big fella with lots of love to give, so he's best suited for a household with adults and older children. While Polaris is comfortable passing dogs on the street, he prefers to be the only fur-baby in the house.He loves going for short to medium distance walks at a nice relaxed pace taking time to sniff the flowers and soak up the sun. At home, he likes playing with his stuffed animals and sleeping 85% of the day away close to his people. Like a true gentleman, he is very polite and well behaved"),
    };

    //Private buttons and texts to display on said buttons and or pictures.
    private ImageView picture;
    private TextView name;
    private TextView desc;

    private Button prev;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //starting your array at index 0
        currentIndex = 0;

        //grabbing the picture, name, and description of the dogs from the array.
        //set this once inside the oncreate so that you dont have to write
        //it out each time for each view.

        //this is an image
        picture = findViewById(R.id.picture);

        // These are text views
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);

        //These are buttons
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        //runs the show dog function
        ShowDog();

        // Event listener for the backward movement in the array, attached to the button
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });
        // Event listener for the forward movement in the array, attached to the button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });
    }

    // Moving forward in the array to view the next dog
    public void increment() {
        currentIndex++;
        ShowDog();
    }
    // Moving backward in the array to view the previous dog
    public void decrement() {
        currentIndex--;
        ShowDog();
    }

    //Our show dogs function that will bring up the info related to each dog in the array
    public void ShowDog() {
        preventBounds();

        DogAdoptions dog = dogs[currentIndex];
        name.setText(dog.name);
        desc.setText(dog.description);

        Drawable pic = getResources().getDrawable(dog.drawableId);
        picture.setImageDrawable(pic);
    }

    //Pointing forward and backwards in the array and the previous and next dog
    public void preventBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        // guarantee the current index is between zero and the length of the array
        currentIndex = Math.max(currentIndex, 0);
        currentIndex = Math.min(currentIndex, dogs.length - 1);

        // deal with the worst
        if (currentIndex == dogs.length - 1) {
            next.setEnabled(false);
        }

        if (currentIndex == 0) {
            prev.setEnabled(false);
        }

    }
}



