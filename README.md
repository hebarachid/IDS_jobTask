# IDS_jobTask
Outline:<br/>
main activity: redirects to the first gallery activity <br/>
gallery_first_page_items: contains the recycler view-adapter bind view<br/>
-->page1GalleryInformation: class that contains id,name, image <br/>
-->first adapter: onBindViewHolder for the recycler view and personalized onClickListener for each holder<br/>
-->fistPageActivity: httpConnection to the get request and onPostExecution to the JsonObject to retrieve that needed holders<br/>
..........................................................................................................................................................................................................................................................................
gallery_second_page_items: contains the recycler view-adapter bind view<br/>
-->page2GalleryInformation: class that contains caption, image <br/>
-->second adapter: onBindViewHolder for the recycler view and personalized onClickListener for each holder<br/>
-->secondPageActivity: httpConnection to the get request and onPostExecution to the JsonObject to retrieve that needed holders, each of which is personalized based on the id when you click one in the first page<br/>
..........................................................................................................................................................................................................................................................................
Guidelines:
click the button in the main activity to go to first gallery activity <br/>
click any position in the recycler view to go to a personalized second activity <br/>

