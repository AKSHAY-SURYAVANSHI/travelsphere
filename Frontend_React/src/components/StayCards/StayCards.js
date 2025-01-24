import React, { useEffect, useState } from 'react';
import './StayCards.css';
import axios from 'axios';
import { Link } from 'react-router-dom';

const StayCards = () => {
    const [stays, setStays] = useState([]);
    const [filteredStays, setFilteredStays] = useState([]);
    const [selectedType, setSelectedType] = useState('all');

    useEffect(() => {
        fetchStays();
    }, []);

    const fetchStays = () => {
        axios.get('http://localhost:8081/hotel/read')
            .then(response => {
                setStays(response.data);
                setFilteredStays(response.data); // Initialize filtered stays with all stays
                console.log(response);
            })
            .catch(error => {
                console.error("There was an error fetching the stays!", error);
            });
    };

    const handleTypeClick = (type) => {
        setSelectedType(type);

        if (type === 'all') {
            setFilteredStays(stays);
        } else {
            setFilteredStays(stays.filter(stay => stay.type === type));
        }
    };

    return (
        <div className="staycontainer">
            <div className="filter-container">
                <button onClick={() => handleTypeClick('a   ll')}>All</button>
                <button onClick={() => handleTypeClick('Hotel')}>Hotel</button>
                <button onClick={() => handleTypeClick('Hostel')}>Hostel</button>
                <button onClick={() => handleTypeClick('Homestay')}>Homestay</button>
                <button onClick={() => handleTypeClick('Villa')}>Villa</button>
                <button onClick={() => handleTypeClick('Pet-Friendly')}>Pet Friendly</button>
            </div>

            <div className="cards-container1">
                {filteredStays.map((stay) => (
                    <div className="card1" key={stay.id}>
                        <img
   src={stay.image}
   className="card-img-top1"
   alt={stay.name}
   onError={(e) => {
       const fallbackUrls = [
           "https://nomadsworld.com/.netlify/images?url=https%3A%2F%2Fapi.nomadsworld.com%2Fwp-content%2Fuploads%2F2018%2F11%2Fnomads-brisbane-hostel-dorm.jpg&w=1920&h=1080",
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_eP3XNWyPRFi0yviShoV-gus1vvHoBoq1qA&s",
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5aumktqWcJui4s_5F31kPm7u8jS0E-j2ijQ&s",
           "https://www.dolomiticlass.it/storage/property/59690/conversions/esterno_invernale_majestic_hotel_siusi-tablet.jpg"
       ];
       const randomIndex = Math.floor(Math.random() * fallbackUrls.length);
       e.target.src = fallbackUrls[randomIndex];
   }}
   />

                        <div className="cardInfo1">
                            <h3>{stay.name}</h3>
                            <div className="seeMoreButton1">
                                <ul>
                                    <li>Location: {stay.city}</li>
                                    <li>Rating: {stay.rating} / 5</li>
                                </ul>
                            </div>
                            <Link to={`/room/${stay.id}`}><button>Explore More</button></Link>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default StayCards;
    